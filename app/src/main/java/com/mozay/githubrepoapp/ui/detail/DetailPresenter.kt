package com.mozay.githubrepoapp.ui.detail

import io.reactivex.disposables.CompositeDisposable


class DetailPresenter : DetailContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: DetailContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: DetailContract.View) {
        this.view = view
    }

}