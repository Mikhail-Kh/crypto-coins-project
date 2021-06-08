package by.khryshchanovich.core.domain.interactors.cryptocoins

import by.khryshchanovich.core.domain.repository.CryptoCoinsRepository
import javax.inject.Inject

class RemoveCryptoCoinsUseCaseImpl @Inject constructor(
    private val cryptoCoinsRepository: CryptoCoinsRepository
) :
    CryptoCoinsUseCase.RemoveCryptoCoinsUseCase {
    override suspend fun invoke() {
        cryptoCoinsRepository.removeCryptoCoins()
    }
}