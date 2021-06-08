package by.khryshchanovich.core.domain.interactors.cryptocoins

import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo
import by.khryshchanovich.core.domain.repository.CryptoCoinsRepository
import javax.inject.Inject

class ShowCryptoCoinsUseCaseImpl @Inject constructor(
    private val cryptoCoinsRepository: CryptoCoinsRepository
) :
    CryptoCoinsUseCase.ShowCryptoCoinsUseCase {
    override suspend fun invoke(): List<CryptoCoinsInfo> {
        return cryptoCoinsRepository.showCryptoCoins()
    }
}