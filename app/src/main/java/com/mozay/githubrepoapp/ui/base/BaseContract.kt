package com.mozay.githubrepoapp.ui.base

import android.content.Context

class BaseContract {

    interface Presenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View {
    }

}