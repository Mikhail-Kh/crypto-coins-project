package by.khryshchanovich.core.data.mappers

import by.khryshchanovich.core.data.database.entity.CryptoCoinsDbEntity
import by.khryshchanovich.core.domain.entity.CryptoCoinsInfo
import javax.inject.Inject

class CryptoCoinsInfoToCryptoCoinsDbEntityMapper @Inject constructor() {
    fun map(from: CryptoCoinsInfo): CryptoCoinsDbEntity {
        return CryptoCoinsDbEntity(
            name = from.name,
            symbol = from.symbol,
            percentChange1h = from.percentChange1h,
            price = from.price,
            idDomain = from.id
        )
    }
}