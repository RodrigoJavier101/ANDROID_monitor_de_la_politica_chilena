package cl.rodrigojavier101.monitordelapoliticachilena.ui.features.diputados_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import cl.rodrigojavier101.monitordelapoliticachilena.R
import cl.rodrigojavier101.monitordelapoliticachilena.databinding.FragmentDiputadoDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class DiputadoDetailFragment : Fragment() {

    private var _binding: FragmentDiputadoDetailBinding? = null
    private val binding get() = _binding!!
    private val diputadosDetailViewModel by viewModels<DiputadoDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDiputadoDetailBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(
            view,
            savedInstanceState
        )

        val idDiputado = arguments?.getString("id")
        val webDiputado = arguments?.getString("web")

        viewEvents()

        lifecycleScope.launch(Dispatchers.IO) {
            val dipDetail = diputadosDetailViewModel.getDiputadoDetail(
                idDiputado!!,
                webDiputado!!
            )

            withContext(Dispatchers.Main) {
                val icon = dipDetail.picture

                with(binding) {
                    Picasso
                        .get()
                        .load(icon)
                        .into(picture)
                    nameDetail.text = dipDetail.nombre
                    partidoDetail.text = dipDetail.partido
                    bancadaDetail.text = dipDetail.bancada
                    distritoDetail.text = dipDetail.distrito
                    regionDetail.text = dipDetail.region
                    comunasDetail.text = dipDetail.comunas
                    periodoDetail.text = dipDetail.periodo
                }

            }
        }
    }

    private fun viewEvents() {
        binding.backIcon.setOnClickListener {
            findNavController().navigate(R.id.action_diputadoDetailFragment_to_diputadosFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}