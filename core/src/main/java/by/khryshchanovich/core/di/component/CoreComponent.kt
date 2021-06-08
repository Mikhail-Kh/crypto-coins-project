package by.khryshchanovich.core.di.component

import by.khryshchanovich.core.di.module.ApiModule
import by.khryshchanovich.core.di.module.ContextModule
import by.khryshchanovich.core.di.module.DaoModule
import by.khryshchanovich.core.di.module.RepositoryModule
import by.khryshchanovich.core.domain.repository.CryptoCoinsRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, ContextModule::class, DaoModule::class, RepositoryModule::class])
interface CoreComponent {
    fun getCryptoCoinsRepository(): CryptoCoinsRepository
}