package by.khryshchanovich.core.data.mappers

import by.khryshchanovich.core.data.network.dto.RatesResponse
import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo
import javax.inject.Inject

class CryptoCoinsInfoFromRatesResponseMapper @Inject constructor() {
    fun map(from: RatesResponse.Data?): CryptoCoinsInfo {
        return CryptoCoinsInfo(
            id = from?.id ?: 0,
            name = from?.name.orEmpty(),
            symbol = from?.symbol.orEmpty(),
            percentChange1h = from?.quote?.uSD?.percentChange1h ?: 0.0,
            price = from?.quote?.uSD?.price ?: 0.0
        )
    }
}