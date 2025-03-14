package cl.rodrigojavier101.monitordelapoliticachilena.data.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class DiputadoNetworkModel(
   @SerializedName("id")
   var id: String = "",

   @SerializedName("nombre")
   var nombre: String = "",

   @SerializedName("apellido")
   var apellido: String = "",

   @SerializedName("distrito")
   var distrito: String = "",

   @SerializedName("partido")
   var partido: String = "",

   @SerializedName("pagina_web")
   var paginaWeb: String = "",

   @SerializedName("mail")
   var mail: String = "default@email.com",

   @SerializedName("picture")
   var picture: String = ""
)
