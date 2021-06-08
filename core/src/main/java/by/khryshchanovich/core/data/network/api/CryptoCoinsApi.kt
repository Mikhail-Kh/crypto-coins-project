package by.khryshchanovich.core.data.network.api

import by.khryshchanovich.core.data.network.dto.RatesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CryptoCoinsApi {
    @GET("v1/cryptocurrency/listings/latest")
    fun getCryptoCoinsAsync() : Deferred<Response<RatesResponse>>
}