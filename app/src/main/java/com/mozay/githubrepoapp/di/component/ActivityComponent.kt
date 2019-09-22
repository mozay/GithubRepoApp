package com.mozay.githubrepoapp.di.component

import com.mozay.githubrepoapp.di.module.ActivityModule
import com.mozay.githubrepoapp.ui.detail.DetailActivity
import com.mozay.githubrepoapp.ui.main.MainActivity
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun contributeMainActivityInjector(mainActivity: MainActivity)

    fun contributeDetailActivityInjector(detailActivity: DetailActivity)
}