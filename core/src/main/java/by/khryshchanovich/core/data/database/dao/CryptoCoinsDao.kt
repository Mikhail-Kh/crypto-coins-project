package by.khryshchanovich.core.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.khryshchanovich.core.data.database.entity.CryptoCoinsDbEntity

@Dao
interface CryptoCoinsDao {
    @Insert
    suspend fun saveCryptoCoins(cryptoCoinsDbEntityList: List<CryptoCoinsDbEntity>)

    @Query("SELECT * FROM CryptoCoinsDbEntity")
    suspend fun showCryptoCoins(): List<CryptoCoinsDbEntity>

    @Query("DELETE FROM CryptoCoinsDbEntity")
    suspend fun removeDatabase()
}