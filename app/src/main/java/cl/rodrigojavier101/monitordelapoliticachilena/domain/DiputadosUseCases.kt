package cl.rodrigojavier101.monitordelapoliticachilena.domain

import cl.rodrigojavier101.monitordelapoliticachilena.data.DiputadosRepository
import cl.rodrigojavier101.monitordelapoliticachilena.domain.pojos.Diputado
import cl.rodrigojavier101.monitordelapoliticachilena.domain.pojos.DiputadoDetail
import kotlinx.coroutines.delay
import javax.inject.Inject

class DiputadosUseCases @Inject constructor(
   private val repository: DiputadosRepository
) {

   suspend fun clearData() {
      repository.clearAllTables()
      delay(800)
   }

   suspend operator fun invoke(): List<Diputado> {
      return repository
         .getDiputadosFromDatabase()
         .ifEmpty {
            repository.getDiputadosFromWebScrap()
         }
   }

   suspend fun getDiputadoDetail(
      id: String,
      url: String
   ): DiputadoDetail {
      return repository.getDiputadoDetail(
         id,
         url
      )
   }

}


