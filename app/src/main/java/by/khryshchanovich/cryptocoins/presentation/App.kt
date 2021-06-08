package by.khryshchanovich.cryptocoins.presentation

import android.app.Application
import by.khryshchanovich.core.di.component.CoreComponent
import by.khryshchanovich.core.di.component.DaggerCoreComponent
import by.khryshchanovich.core.di.module.ContextModule
import by.khryshchanovich.cryptocoins.presentation.di.component.AppComponent
import by.khryshchanovich.cryptocoins.presentation.di.module.AppModule
import by.khryshchanovich.cryptocoins.presentation.di.component.DaggerAppComponent

class App : Application() {
    private lateinit var appComponent: AppComponent
    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        coreComponent = DaggerCoreComponent.builder()
            .contextModule(ContextModule(this))
            .build()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .coreComponent(coreComponent)
            .build()
    }

    fun getAppComponent() = appComponent
}