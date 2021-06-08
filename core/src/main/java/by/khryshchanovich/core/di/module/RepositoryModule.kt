package by.khryshchanovich.core.di.module

import by.khryshchanovich.core.data.repository.cryptocoins.CryptoCoinsRepositoryImpl
import by.khryshchanovich.core.domain.repository.CryptoCoinsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindCryptoCoinsRepository(
        cryptoCoinsRepositoryImpl: CryptoCoinsRepositoryImpl
    ): CryptoCoinsRepository
}