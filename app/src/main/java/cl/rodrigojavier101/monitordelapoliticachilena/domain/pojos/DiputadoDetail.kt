package cl.rodrigojavier101.monitordelapoliticachilena.domain.pojos

import androidx.annotation.Keep

@Keep
data class DiputadoDetail(
   val idDiputadoDetail: String = "",
   val nombre: String = "",
   var region: String = "",
   var comunas: String = "",
   var distrito: String = "",
   val partido: String = "",
   val periodo: String = "",
   val bancada: String = "",
   val picture: String = ""
)
