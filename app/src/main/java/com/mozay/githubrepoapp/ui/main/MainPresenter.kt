package com.mozay.githubrepoapp.ui.main

import com.mozay.githubrepoapp.api.ApiService
import com.mozay.githubrepoapp.models.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter: MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: ApiService = ApiService.create()
    private lateinit var view: MainContract.View

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }

    override fun searchSubmitClickListener(search: String) {
        view.showProgress(true)
        val subscribe = api.getRepoList(search).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: List<Repo>? ->
                view.showProgress(false)
                if(!list.isNullOrEmpty()){
                    view.hideNotFoundScreen()
                    view.showRepoList(list!!)
                }else{
                    view.showNotFoundScreen()
                }

            }, { error ->
                view.showProgress(false)
                view.showNotFoundScreen()
                view.showErrorMessage(error.localizedMessage)
            })

        subscriptions.add(subscribe)
    }

}