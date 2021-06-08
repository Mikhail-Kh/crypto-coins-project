package by.khryshchanovich.core.data.repository.cryptocoins

import by.khryshchanovich.core.data.database.dao.CryptoCoinsDao
import by.khryshchanovich.core.data.database.entity.CryptoCoinsDbEntity
import by.khryshchanovich.core.data.network.api.CryptoCoinsApi
import by.khryshchanovich.core.data.network.dto.RatesResponse
import retrofit2.Response
import javax.inject.Inject

class CryptoCoinsDataSource @Inject constructor(
    private val cryptoCoinsApi: CryptoCoinsApi,
    private val cryptoCoinsDao: CryptoCoinsDao
) {
    suspend fun getCryptoCoins(): Response<RatesResponse> {
        return cryptoCoinsApi.getCryptoCoinsAsync().await()
    }

    suspend fun saveCryptoCoinsToDatabase(cryptoCoinsDbList: List<CryptoCoinsDbEntity>) {
        cryptoCoinsDao.saveCryptoCoins(cryptoCoinsDbList)
    }

    suspend fun showCryptoCoinsFromDatabase(): List<CryptoCoinsDbEntity> {
        return cryptoCoinsDao.showCryptoCoins()
    }

    suspend fun removeDatabase() {
        cryptoCoinsDao.removeDatabase()
    }
}