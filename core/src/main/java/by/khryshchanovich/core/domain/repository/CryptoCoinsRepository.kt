package by.khryshchanovich.core.domain.repository

import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo

interface CryptoCoinsRepository {
    suspend fun getCryptoCoins(): List<CryptoCoinsInfo>
    suspend fun removeCryptoCoins()
    suspend fun saveCryptoCoins(listCryptoCoinsInfo: List<CryptoCoinsInfo>)
    suspend fun showCryptoCoins(): List<CryptoCoinsInfo>
}