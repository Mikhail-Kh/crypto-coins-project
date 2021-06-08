package by.khryshchanovich.core.di.module

import android.content.Context
import by.khryshchanovich.core.data.database.dao.CryptoCoinsDao
import by.khryshchanovich.core.data.database.db.DatabaseProvider
import dagger.Module
import dagger.Provides

@Module
class DaoModule {
    @Provides
    fun provideCryptoCoinsDao(context: Context): CryptoCoinsDao {
        return DatabaseProvider.provide(context).getDao()
    }
}