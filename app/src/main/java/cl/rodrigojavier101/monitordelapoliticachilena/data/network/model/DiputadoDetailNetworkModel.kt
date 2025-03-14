package cl.rodrigojavier101.monitordelapoliticachilena.data.network.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

@Keep
data class DiputadoDetailNetworkModel(

   @SerializedName("id")
   val id: String = "",

   @SerializedName("nombre")
   val nombre: String = "",

   @ColumnInfo("region")
   val region: String = "",

   @SerializedName("comunas")
   val comunas: String = "",

   @SerializedName("distrito")
   val distrito: String = "",

   @SerializedName("partido")
   val partido: String = "",

   @SerializedName("periodo")
   val periodo: String = "",

   @SerializedName("bancada")
   val bancada: String = "",

   @SerializedName("picture")
   val picture: String = ""
)
