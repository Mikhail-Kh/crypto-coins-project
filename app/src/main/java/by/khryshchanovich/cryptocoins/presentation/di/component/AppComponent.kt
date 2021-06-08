package by.khryshchanovich.cryptocoins.presentation.di.component

import by.khryshchanovich.core.di.component.CoreComponent
import by.khryshchanovich.core.di.scope.ComponentScope
import by.khryshchanovich.cryptocoins.presentation.di.module.AppModule
import by.khryshchanovich.cryptocoins.presentation.view.activity.CryptoCoinsActivity
import dagger.Component

@Component(modules = [AppModule::class], dependencies = [CoreComponent::class])
@ComponentScope
interface AppComponent {
    fun initializeCryptoCoinsActivity(cryptoCoinsActivity: CryptoCoinsActivity)
}