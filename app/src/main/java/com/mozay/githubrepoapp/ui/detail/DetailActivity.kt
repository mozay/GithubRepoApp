package com.mozay.githubrepoapp.ui.detail

import android.app.Activity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.mozay.githubrepoapp.R
import com.mozay.githubrepoapp.di.component.DaggerActivityComponent
import com.mozay.githubrepoapp.di.module.ActivityModule
import com.mozay.githubrepoapp.models.Repo
import com.mozay.githubrepoapp.models.RepoOwner
import com.mozay.githubrepoapp.ui.main.MainActivity
import com.mozay.githubrepoapp.util.AppToast
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : Activity(), DetailContract.View {

    @Inject
    lateinit var presenter: DetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initialize()
        initData()
    }

    fun initialize(){
        injectDependency()
        presenter.attach(this)
    }

    fun initData(){
        val owner = getIntent().getSerializableExtra(MainActivity.EXTRA_OWNER) as? RepoOwner
        val repo = getIntent().getSerializableExtra(MainActivity.EXTRA_REPO) as? Repo

        Glide.with(this).load(owner?.avatar_url).into(imgOwner)

        txtOwnerName.text = owner?.login
        txtStarCount.text = repo?.stargazers_count.toString()
        txtIssueCount.text = repo?.open_issues_count.toString()
        txtForkedCount.text = repo?.forks_count.toString()

        //toolbar
        txtRepoName.text = repo?.name
        toolBack.setOnClickListener {finish() }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun showMessage(state: Byte) {
        var message = if(state == ADD_FAV) getString(R.string.addfav)
                           else getString(R.string.deletefav)

        AppToast.showShort(this@DetailActivity,message)
    }

    fun injectDependency(){
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.contributeDetailActivityInjector(this@DetailActivity)
    }

    companion object{
        const val ADD_FAV :Byte = 1
    }
}
