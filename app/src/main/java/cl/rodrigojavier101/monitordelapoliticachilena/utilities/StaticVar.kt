package cl.rodrigojavier101.monitordelapoliticachilena.utilities

class StaticVar {
    companion object {

        /* LOG MESSAGE  */
        const val TAG = "TAG-------->"

        /*database consts*/
        const val DATABASE_VERSION_OLD = 2
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "monitor_db"
        const val TABLE_DIPUTADOS = "diputados"
        const val TABLE_DIPUTADOS_DETAIL = "diputados_detail"

        /*constantes diputados actuales*/
        const val BASE_URL_DIP_ACT = "https://www.camara.cl/"
        const val END_POINT_DIP_ACT = "diputados/diputados.aspx#mostrarDiputados"
        const val DIPUTADOS_DIP_ACT = "diputados/"

    }
}