package by.khryshchanovich.core.domain.interactors.cryptocoins

import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo
import by.khryshchanovich.core.domain.repository.CryptoCoinsRepository
import javax.inject.Inject

class SaveCryptoCoinsUseCaseImpl @Inject constructor(
    private val cryptoCoinsRepository: CryptoCoinsRepository
) :
    CryptoCoinsUseCase.SaveCryptoCoinsUseCase {
    override suspend fun invoke(listCryptoCoinsInfo: List<CryptoCoinsInfo>) {
        cryptoCoinsRepository.saveCryptoCoins(listCryptoCoinsInfo)
    }
}