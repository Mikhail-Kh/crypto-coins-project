package by.khryshchanovich.core.domain.interactors.cryptocoins

import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo
import by.khryshchanovich.core.domain.repository.CryptoCoinsRepository
import javax.inject.Inject

class GetCryptoCoinsUseCaseImpl @Inject constructor(
    private val cryptoCoinsRepository: CryptoCoinsRepository
) :
    CryptoCoinsUseCase.GetCryptoCoinsUseCase {
    override suspend fun invoke(): List<CryptoCoinsInfo> {
        return cryptoCoinsRepository.getCryptoCoins()
    }
}