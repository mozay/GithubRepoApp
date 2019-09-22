package com.mozay.githubrepoapp.ui.main

import com.mozay.githubrepoapp.models.Repo
import com.mozay.githubrepoapp.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun showRepoList(repos: List<Repo>)
        fun showErrorMessage(error: String)
        fun showProgress(show: Boolean)
        fun showNotFoundScreen()
        fun hideNotFoundScreen()
    }

    interface Presenter: BaseContract.Presenter<MainContract.View> {
        fun searchSubmitClickListener(search: String)
    }

}