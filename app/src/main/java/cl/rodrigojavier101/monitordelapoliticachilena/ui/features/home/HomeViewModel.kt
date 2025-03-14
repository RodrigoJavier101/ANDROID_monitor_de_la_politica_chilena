package cl.rodrigojavier101.monitordelapoliticachilena.ui.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import cl.rodrigojavier101.monitordelapoliticachilena.data.ConnectivityRepository
import cl.rodrigojavier101.monitordelapoliticachilena.domain.DiputadosUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    connectivityRepository: ConnectivityRepository,
    private val diputadosUseCase: DiputadosUseCases,
) : ViewModel() {

    val isOnline = connectivityRepository.isConnected.asLiveData()

    private val _spinner = MutableLiveData<Boolean>(true)
    var spinner: LiveData<Boolean> = _spinner

    suspend fun clearData(badgeState: Boolean) {
        viewModelScope.launch(Dispatchers.Main) {
            _spinner.value = !badgeState
        }

        diputadosUseCase.clearData()

        viewModelScope.launch(Dispatchers.Main) {
            _spinner.value = badgeState
        }
    }

}