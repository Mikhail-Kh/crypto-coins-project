package by.khryshchanovich.core.data.repository.cryptocoins

import by.khryshchanovich.core.data.mappers.CryptoCoinsInfoFromCryptoCoinsDbEntityMapper
import by.khryshchanovich.core.data.mappers.CryptoCoinsInfoFromRatesResponseMapper
import by.khryshchanovich.core.data.mappers.CryptoCoinsInfoToCryptoCoinsDbEntityMapper
import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo
import by.khryshchanovich.core.domain.repository.CryptoCoinsRepository
import javax.inject.Inject

class CryptoCoinsRepositoryImpl @Inject constructor(
    private val cryptoCoinsDataSource: CryptoCoinsDataSource,
    private val cryptoCoinsInfoFromRatesResponseMapper: CryptoCoinsInfoFromRatesResponseMapper,
    private val cryptoCoinsInfoFromCryptoCoinsDbEntityMapper: CryptoCoinsInfoFromCryptoCoinsDbEntityMapper,
    private val cryptoCoinsInfoToCryptoCoinsDbEntityMapper: CryptoCoinsInfoToCryptoCoinsDbEntityMapper
) :
    CryptoCoinsRepository {
    override suspend fun getCryptoCoins(): List<CryptoCoinsInfo> {
        val response = cryptoCoinsDataSource.getCryptoCoins()
        if (response.isSuccessful) {
            return response.body()?.data?.map {
                cryptoCoinsInfoFromRatesResponseMapper.map(it)
            }!!
        } else {
            throw Throwable(response.message())
        }
    }

    override suspend fun saveCryptoCoins(listCryptoCoinsInfo: List<CryptoCoinsInfo>) {
        val listDbCryptoCoins = listCryptoCoinsInfo.map { cryptoCoinsInfo ->
            cryptoCoinsInfoToCryptoCoinsDbEntityMapper.map(cryptoCoinsInfo)
        }
        cryptoCoinsDataSource.saveCryptoCoinsToDatabase(listDbCryptoCoins)
    }

    override suspend fun showCryptoCoins(): List<CryptoCoinsInfo> {
        return cryptoCoinsDataSource.showCryptoCoinsFromDatabase().map { cryptoCoinsDbEntity ->
            cryptoCoinsInfoFromCryptoCoinsDbEntityMapper.map(cryptoCoinsDbEntity)
        }
    }

    override suspend fun removeCryptoCoins() {
        cryptoCoinsDataSource.removeDatabase()
    }
}