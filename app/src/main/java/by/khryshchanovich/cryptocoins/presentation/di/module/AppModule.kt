package by.khryshchanovich.cryptocoins.presentation.di.module

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {
    @Provides
    fun provideApplication(): Application {
        return application
    }
}