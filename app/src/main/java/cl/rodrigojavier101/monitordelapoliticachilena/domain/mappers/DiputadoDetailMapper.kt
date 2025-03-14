package cl.rodrigojavier101.monitordelapoliticachilena.domain.mappers

import cl.rodrigojavier101.monitordelapoliticachilena.domain.pojos.DiputadoDetail
import cl.rodrigojavier101.monitordelapoliticachilena.data.database.entities.DiputadoDetailEntity
import cl.rodrigojavier101.monitordelapoliticachilena.data.network.model.DiputadoDetailNetworkModel


fun DiputadoDetailEntity.entityDetailToDomain() = DiputadoDetail(
    idDiputadoDetail = diputadoId,
    nombre = nombre,
    region = region,
    comunas = comunas,
    distrito = distrito,
    partido = partido,
    periodo = periodo,
    bancada = bancada,
    picture = picture,
)

fun DiputadoDetailNetworkModel.networkDetailToDomain() = DiputadoDetail(
    nombre = nombre,
    region = region,
    comunas = comunas,
    distrito = distrito,
    partido = partido,
    periodo = periodo,
    bancada = bancada,
    picture = picture
)

fun DiputadoDetailNetworkModel.networkDetailToEntity() = DiputadoDetailEntity(
//   id = 0,
    diputadoId = id,
    nombre = nombre,
    region = region,
    comunas = comunas,
    distrito = distrito,
    partido = partido,
    periodo = periodo,
    bancada = bancada,
    picture = picture
)

