package cl.rodrigojavier101.monitordelapoliticachilena.data.database.entities

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.StaticVar.Companion.TABLE_DIPUTADOS

@Keep
@Entity(TABLE_DIPUTADOS)
data class DiputadoEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: String = "",

    @ColumnInfo("nombre")
    val nombre: String,

    @ColumnInfo("apellido")
    val apellido: String,

    @ColumnInfo("distrito")
    val distrito: String,

    @ColumnInfo("partido")
    val partido: String,

    @ColumnInfo("pagina_web")
    val paginaWeb: String,

    @ColumnInfo("picture")
    val picture: String = "",
)
