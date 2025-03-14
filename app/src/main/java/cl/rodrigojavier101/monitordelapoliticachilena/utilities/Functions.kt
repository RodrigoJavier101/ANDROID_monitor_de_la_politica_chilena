package cl.rodrigojavier101.monitordelapoliticachilena.utilities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


fun isOnlineN( context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//   if (connectivityManager != null) {
    val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    if (capabilities != null) {
        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
//         Log.i(TAG, "NetworkCapabilities.TRANSPORT_CELLULAR")
            return true
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
//         Log.i(TAG, "NetworkCapabilities.TRANSPORT_WIFI")
            return true
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
//         Log.i(TAG, "NetworkCapabilities.TRANSPORT_ETHERNET")
            return true
        }
    }
//   }
    return false
}


