package cl.rodrigojavier101.monitordelapoliticachilena.data.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.rodrigojavier101.monitordelapoliticachilena.data.database.entities.DiputadoDetailEntity
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.StaticVar.Companion.TABLE_DIPUTADOS_DETAIL

@Dao
interface DiputadosDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiputadoDetail(diputado: DiputadoDetailEntity)

    @Query("DELETE FROM $TABLE_DIPUTADOS_DETAIL")
    suspend fun clearDiputadosDetail()

    @Query("SELECT * FROM $TABLE_DIPUTADOS_DETAIL WHERE diputado_id = :id LIMIT 1")
    suspend fun getDiputadoDetail(id: String): DiputadoDetailEntity?

    @Query("SELECT * FROM $TABLE_DIPUTADOS_DETAIL")
    suspend fun getAllDiputadoDetail(): List<DiputadoDetailEntity>

//   @Query("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='$TABLE_DIPUTADOS'")
//   fun resetTable()

}