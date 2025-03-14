package cl.rodrigojavier101.monitordelapoliticachilena.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import cl.rodrigojavier101.monitordelapoliticachilena.data.database.room.MonitorDatabase
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.StaticVar.Companion.DATABASE_NAME
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.StaticVar.Companion.DATABASE_VERSION
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.StaticVar.Companion.DATABASE_VERSION_OLD
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.StaticVar.Companion.TABLE_DIPUTADOS
import cl.rodrigojavier101.monitordelapoliticachilena.utilities.StaticVar.Companion.TABLE_DIPUTADOS_DETAIL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun providesRoom(
        @ApplicationContext
        context: Context
    ) = Room
        .databaseBuilder(
            context,
            MonitorDatabase::class.java,
            DATABASE_NAME
        )
        .fallbackToDestructiveMigration() // this make me loose data
//      .addMigrations(MIGRATION_1_2) // this prevents data loose
        .build()

    @Singleton
    @Provides
    fun provideDiputadosDao(db: MonitorDatabase) = db.diputadosDao()

    @Singleton
    @Provides
    fun provideDiputadoDetailDao(db: MonitorDatabase) = db.diputadoDetailDao()

}

val MIGRATION_1_2 = object : Migration(
    DATABASE_VERSION_OLD,
    DATABASE_VERSION
) {
    override fun migrate(db: SupportSQLiteDatabase) {
        // database.execSQL(...) EXAMPLE
        db.execSQL("DROP TABLE IF EXISTS $TABLE_DIPUTADOS");
        db.execSQL("DROP TABLE IF EXISTS $TABLE_DIPUTADOS_DETAIL");

        /*
        Migration using temporary table

          // Remove first and last name column from profile
          // create new table
          database.execSQL("CREATE TABLE IF NOT EXISTS `profile_new` (`id` INTEGER NOT NULL, `nickName` TEXT NOT NULL, `bio` TEXT NOT NULL, PRIMARY KEY(`id`))")
          // create nickname if needed
          database.execSQL("UPDATE `profile` SET `nickName` = `firstName` || ' ' || `lastName` WHERE `nickName` IS NULL")
          // copy data to new table
          database.execSQL("INSERT INTO `profile_new` (`id`, `nickName`, `bio`) SELECT `id`, `nickName`, `bio` FROM `profile`")
          // remove the old table
          database.execSQL("DROP TABLE `profile`")
          // rename new table
          database.execSQL("ALTER TABLE `profile_new` RENAME TO `profile`")
        * */
    }
}
