package by.khryshchanovich.core.data.mappers

import by.khryshchanovich.core.data.database.entity.CryptoCoinsDbEntity
import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo
import javax.inject.Inject

class CryptoCoinsInfoFromCryptoCoinsDbEntityMapper @Inject constructor() {
    fun map(from: CryptoCoinsDbEntity): CryptoCoinsInfo {
        return CryptoCoinsInfo(
            id = from.idDomain,
            name = from.name,
            symbol = from.symbol,
            percentChange1h = from.percentChange1h,
            price = from.price
        )
    }
}