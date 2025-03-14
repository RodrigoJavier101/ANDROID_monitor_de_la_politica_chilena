package cl.rodrigojavier101.monitordelapoliticachilena.ui.features.diputados

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cl.rodrigojavier101.monitordelapoliticachilena.data.ConnectivityRepository
import cl.rodrigojavier101.monitordelapoliticachilena.domain.DiputadosUseCases
import cl.rodrigojavier101.monitordelapoliticachilena.domain.pojos.Diputado
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiputadosViewModel
@Inject constructor(
    private val diputadosUseCase: DiputadosUseCases,
    connectivityRepository: ConnectivityRepository
) : ViewModel() {

    var diputadosActualesList = MutableLiveData<List<Diputado>>(mutableListOf())
    val isOnline = connectivityRepository.isConnected.asLiveData()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            getDiputadosActualesList()
        }
    }

    private suspend fun getDiputadosActualesList() {
        diputadosActualesList.postValue(diputadosUseCase.invoke())
    }

}
