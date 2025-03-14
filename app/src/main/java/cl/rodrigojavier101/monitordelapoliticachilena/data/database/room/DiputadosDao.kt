package cl.rodrigojavier101.monitordelapoliticachilena.data.database.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import cl.rodrigojavier101.monitordelapoliticachilena.data.database.entities.DiputadoEntity
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.StaticVar.Companion.TABLE_DIPUTADOS

@Dao
interface DiputadosDao {

    /* suspend permite liberar el hilo principal y se puede usar en un viewmodel*//*pero si se quiere usar el livedata/flows/RxJava/Waba?? no se pone en suspend*/
    @Query("SELECT * FROM $TABLE_DIPUTADOS")
    suspend fun getAllDiputados(): List<DiputadoEntity>

    @Query("SELECT * FROM $TABLE_DIPUTADOS WHERE id = :id")
    suspend fun getDiputadoEntity(id: String): DiputadoEntity

    @Update
    suspend fun updateDiputadoEntity(diputado: DiputadoEntity)

    @Delete
    suspend fun deleteDiputadoEntity(diputado: DiputadoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDiputadosEntity(diputados: List<DiputadoEntity>)

    @Query("DELETE FROM $TABLE_DIPUTADOS")
    suspend fun clearDiputadosTable()
}