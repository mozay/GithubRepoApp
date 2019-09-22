package com.mozay.githubrepoapp.di.module

import android.app.Activity
import com.mozay.githubrepoapp.ui.detail.DetailContract
import com.mozay.githubrepoapp.ui.detail.DetailPresenter
import com.mozay.githubrepoapp.ui.main.MainContract
import com.mozay.githubrepoapp.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun provideMainPresenter(): MainContract.Presenter {
        return MainPresenter()
    }

    @Provides
    fun provideDetailPresenter(): DetailContract.Presenter {
        return DetailPresenter()
    }
}