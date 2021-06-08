package by.khryshchanovich.core.data.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.khryshchanovich.core.data.database.dao.CryptoCoinsDao
import by.khryshchanovich.core.data.database.entity.CryptoCoinsDbEntity

@Database(entities = [CryptoCoinsDbEntity::class], version = 1)
abstract class CryptoCoinsDatabase : RoomDatabase() {
    abstract fun getDao(): CryptoCoinsDao
}

object DatabaseProvider {
    fun provide(context: Context) =
        Room.databaseBuilder(context, CryptoCoinsDatabase::class.java, "CryptoCoinsDatabase").build()
}