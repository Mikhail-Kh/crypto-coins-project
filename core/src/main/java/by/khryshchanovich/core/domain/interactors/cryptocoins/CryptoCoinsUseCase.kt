package by.khryshchanovich.core.domain.interactors.cryptocoins

import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo

interface CryptoCoinsUseCase {
    interface GetCryptoCoinsUseCase {
        suspend fun invoke(): List<CryptoCoinsInfo>
    }

    interface ShowCryptoCoinsUseCase {
        suspend fun invoke(): List<CryptoCoinsInfo>
    }

    interface SaveCryptoCoinsUseCase {
        suspend fun invoke(listCryptoCoinsInfo: List<CryptoCoinsInfo>)
    }

    interface RemoveCryptoCoinsUseCase {
        suspend fun invoke()
    }
}