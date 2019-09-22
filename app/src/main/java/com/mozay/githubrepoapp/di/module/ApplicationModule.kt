package com.mozay.githubrepoapp.di.module

import android.app.Application
import com.mozay.githubrepoapp.BaseApp
import com.mozay.githubrepoapp.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}