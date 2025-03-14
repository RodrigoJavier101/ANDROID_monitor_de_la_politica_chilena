package cl.antoinette.monitor_politico_econmico.ui.features.diputados

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cl.antoinette.monitor_politico_econmico.data.ConnectivityRepository
import cl.antoinette.monitor_politico_econmico.domain.DiputadosUseCases
import cl.antoinette.monitor_politico_econmico.domain.pojos.Diputado
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
