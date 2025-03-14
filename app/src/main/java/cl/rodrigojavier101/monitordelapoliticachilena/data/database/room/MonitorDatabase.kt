package cl.rodrigojavier101.monitordelapoliticachilena.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.rodrigojavier101.monitordelapoliticachilena.data.database.entities.DiputadoDetailEntity
import cl.rodrigojavier101.monitordelapoliticachilena.data.database.entities.DiputadoEntity
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.StaticVar.Companion.DATABASE_VERSION

@Database(
    version = DATABASE_VERSION,
    entities = [DiputadoEntity::class, DiputadoDetailEntity::class],
// the schema is no exported to git
    exportSchema = false
)
abstract class MonitorDatabase : RoomDatabase() {
    abstract fun diputadosDao(): DiputadosDao
    abstract fun diputadoDetailDao(): DiputadosDetailDao
}