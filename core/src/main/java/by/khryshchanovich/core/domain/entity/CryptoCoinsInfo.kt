package by.khryshchanovich.core.domain.entity

data class CryptoCoinsInfo(
    val id: Int,
    val name: String,
    val symbol: String,
    val percentChange1h: Double,
    val price: Double
)