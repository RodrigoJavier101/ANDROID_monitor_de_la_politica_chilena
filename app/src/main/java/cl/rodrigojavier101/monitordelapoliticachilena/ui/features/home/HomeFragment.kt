package cl.rodrigojavier101.monitordelapoliticachilena.ui.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import cl.rodrigojavier101.monitordelapoliticachilena.R
import cl.rodrigojavier101.monitordelapoliticachilena.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        buttonIrADipActuales.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_diputadosFragment)
        }

        buttonRecall.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                homeViewModel.clearData(badge.isVisible)
            }
        }

        homeViewModel.spinner.observe(viewLifecycleOwner) {
            badge.isVisible = it
            progressbar.isVisible = !it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}