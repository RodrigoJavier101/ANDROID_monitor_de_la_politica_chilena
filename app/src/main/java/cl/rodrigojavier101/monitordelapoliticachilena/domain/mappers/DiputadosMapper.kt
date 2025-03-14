package cl.rodrigojavier101.monitordelapoliticachilena.domain.mappers

import cl.rodrigojavier101.monitordelapoliticachilena.data.database.entities.DiputadoEntity
import cl.rodrigojavier101.monitordelapoliticachilena.data.network.model.DiputadoNetworkModel
import cl.rodrigojavier101.monitordelapoliticachilena.domain.pojos.Diputado

/* mapping from entity to pojo ni domain*/
fun DiputadoEntity.entityToDomain() = Diputado(
   idDiputadoActual = id,
   nombre = nombre,
   apellido = apellido,
   distrito = distrito,
   partido = partido,
   paginaWeb = paginaWeb,
   picture = picture,
)

fun DiputadoNetworkModel.networkToDomain() = Diputado(
   idDiputadoActual = id,
   nombre = nombre,
   apellido = apellido,
   distrito = distrito,
   partido = partido,
   paginaWeb = paginaWeb,
   picture = picture,
)

fun DiputadoNetworkModel.networkToEntity() = DiputadoEntity(
   id = id,
   nombre = nombre,
   apellido = apellido,
   distrito = distrito,
   partido = partido,
   paginaWeb = paginaWeb,
   picture = picture,
)
