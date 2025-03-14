package cl.rodrigojavier101.monitordelapoliticachilena.ui.features.diputados

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import cl.rodrigojavier101.monitordelapoliticachilena.R
import cl.rodrigojavier101.monitordelapoliticachilena.databinding.FragmentDiputadosActualesBinding
import cl.rodrigojavier101.monitordelapoliticachilena.ui.features.diputados.adapter.DiputadosAdapter
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.ExtensionFunctions.Companion.initRecyclerView
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.isOnlineN
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DiputadosFragment : Fragment() {

    private var _binding: FragmentDiputadosActualesBinding? = null
    private val binding get() = _binding!!

    private val diputadosViewModel by viewModels<DiputadosViewModel>()
    private lateinit var diputadosAdapter: DiputadosAdapter

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiputadosActualesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        initUIState()
        viewEvents()
    }

    private fun viewEvents() {
        binding.backIcon.setOnClickListener {
            findNavController().navigate(R.id.action_diputadosFragment_to_homeFragment)
        }
    }

    private fun initUIState() {

        diputadosViewModel.isOnline.observe(viewLifecycleOwner) { isOnline ->
            if (isOnline || isOnlineN(requireContext())) {
                binding.internetMessage.visibility = View.GONE

                lifecycleScope.launch {
                    repeatOnLifecycle(Lifecycle.State.STARTED) {
                        diputadosViewModel.diputadosActualesList.observe(viewLifecycleOwner) {
                            diputadosAdapter.setItemInTheView(it)
                        }
                    }
                }

            } else {
                binding.internetMessage.visibility = View.VISIBLE
            }
        }
    }

    private fun initList() {
        diputadosAdapter = DiputadosAdapter()
        initRecyclerView(binding.recyclerViewDiputadosActuales, requireContext(), diputadosAdapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}