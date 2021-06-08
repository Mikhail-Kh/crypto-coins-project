package by.khryshchanovich.cryptocoins.presentation.utils

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

fun isNetworkConnected(app: Application): Boolean {
    val connectivityManager =
        app.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    return activeNetwork?.isConnectedOrConnecting == true
}