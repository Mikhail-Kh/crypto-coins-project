package by.khryshchanovich.core.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CryptoCoinsDbEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val name: String,
    val symbol: String,
    val percentChange1h: Double,
    val price: Double,
    val idDomain: Int
)