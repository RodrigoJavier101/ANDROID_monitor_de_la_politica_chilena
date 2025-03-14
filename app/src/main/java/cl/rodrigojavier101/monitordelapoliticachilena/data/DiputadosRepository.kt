package cl.rodrigojavier101.monitordelapoliticachilena.data

import cl.rodrigojavier101.monitordelapoliticachilena.data.database.room.DiputadosDao
import cl.rodrigojavier101.monitordelapoliticachilena.data.database.room.DiputadosDetailDao
import cl.rodrigojavier101.monitordelapoliticachilena.domain.mappers.entityDetailToDomain
import cl.rodrigojavier101.monitordelapoliticachilena.domain.mappers.entityToDomain
import cl.rodrigojavier101.monitordelapoliticachilena.domain.mappers.networkDetailToDomain
import cl.rodrigojavier101.monitordelapoliticachilena.domain.mappers.networkDetailToEntity
import cl.rodrigojavier101.monitordelapoliticachilena.domain.mappers.networkToDomain
import cl.rodrigojavier101.monitordelapoliticachilena.domain.mappers.networkToEntity
import cl.rodrigojavier101.monitordelapoliticachilena.data.network.DiputadoDetailWebScrapProvider
import cl.rodrigojavier101.monitordelapoliticachilena.data.network.DiputadosWebScrapProvider
import cl.rodrigojavier101.monitordelapoliticachilena.domain.pojos.Diputado
import cl.rodrigojavier101.monitordelapoliticachilena.domain.pojos.DiputadoDetail
import javax.inject.Inject

class DiputadosRepository @Inject constructor(
   private val dao: DiputadosDao,
   private val daoDetail: DiputadosDetailDao,
   private val diputadosWebscrapProvider: DiputadosWebScrapProvider,
   private val diputadoDetailWebscrapProvider: DiputadoDetailWebScrapProvider
) {

   suspend fun getDiputadosFromWebScrap(): List<Diputado> {
      val response = diputadosWebscrapProvider.getDiputadosActuales()
      dao.insertAllDiputadosEntity(response.map {
         it!!.networkToEntity()
      })
      return response.map {
         it!!.networkToDomain()
      }
   }

   suspend fun getDiputadosFromDatabase(): List<Diputado> {
      return dao
         .getAllDiputados()
         .map { it.entityToDomain() }
   }

   suspend fun clearAllTables() {
      dao.clearDiputadosTable()
      daoDetail.clearDiputadosDetail()
   }

   suspend fun getDiputadoDetail(
      id: String,
      url: String
   ): DiputadoDetail {


      return daoDetail
         .getDiputadoDetail(id)
         .let {
            it
               ?.entityDetailToDomain()
               .let {
                  val diputadoWS = diputadoDetailWebscrapProvider.getDiputadoDetailNetwork(url)
                  daoDetail.insertDiputadoDetail(diputadoWS.networkDetailToEntity())
                  diputadoWS.networkDetailToDomain()
               }
         }

   }
}