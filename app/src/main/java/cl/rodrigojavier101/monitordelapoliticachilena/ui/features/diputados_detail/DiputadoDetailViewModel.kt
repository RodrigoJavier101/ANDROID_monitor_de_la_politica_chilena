package cl.rodrigojavier101.monitordelapoliticachilena.ui.features.diputados_detail

import androidx.lifecycle.ViewModel
import cl.rodrigojavier101.monitordelapoliticachilena.data.ConnectivityRepository
import cl.rodrigojavier101.monitordelapoliticachilena.domain.DiputadosUseCases
import cl.rodrigojavier101.monitordelapoliticachilena.domain.pojos.DiputadoDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiputadoDetailViewModel @Inject constructor(
    private val diputadosUseCase: DiputadosUseCases,
    connectivityRepository: ConnectivityRepository
) : ViewModel() {

    suspend fun getDiputadoDetail(
        id: String,
        url: String
    ): DiputadoDetail {
        return diputadosUseCase.getDiputadoDetail(
            id,
            url
        )
    }
}