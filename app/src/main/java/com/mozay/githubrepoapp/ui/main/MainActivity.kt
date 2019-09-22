package com.mozay.githubrepoapp.ui.main

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mozay.githubrepoapp.R
import com.mozay.githubrepoapp.di.component.DaggerActivityComponent
import com.mozay.githubrepoapp.di.module.ActivityModule
import com.mozay.githubrepoapp.models.Repo
import com.mozay.githubrepoapp.models.RepoOwner
import com.mozay.githubrepoapp.ui.detail.DetailActivity
import com.mozay.githubrepoapp.util.*
import com.mozay.githubrepoapp.util.AppToast.Companion.showLong
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View, RepoAdapter.onItemClickListener,  NetworkReceiver.ConnectivityReceiverListener  {

    @Inject
    lateinit var presenter: MainContract.Presenter

    var networkState = true
    private val networkChangeReceiver = NetworkReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
    }

    fun initialize(){
        injectDependency()
        presenter.attach(this)

        registerReceiver(networkChangeReceiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )

        btnSubmit.setOnClickListener {
            if(!networkState){
                showLong(this@MainActivity, getString(R.string.network_error))
            }else if(edtSearchBox.text.toString().validateString()){
                presenter.searchSubmitClickListener(edtSearchBox.text.trim().toString())
            }else{
                showLong(this@MainActivity,getString(R.string.enter_username))
            }
        }
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        networkState = isConnected
        if(!isConnected) {
           showLong(this@MainActivity, getString(R.string.network_error))
       }
    }

    override fun onResume() {
        super.onResume()
        NetworkReceiver.connectivityReceiverListener = this
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(networkChangeReceiver)
    }

    override fun showNotFoundScreen() {
        recyRepoList.gone()
        notfoundView.visible()
    }

    override fun hideNotFoundScreen() {
        notfoundView.gone()
    }

    override fun showRepoList(repos: List<Repo>) {
        var adapter = RepoAdapter(this@MainActivity, repos.toMutableList(), this)
        recyRepoList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyRepoList.setAdapter(adapter)
        recyRepoList.visible()
    }

    override fun showErrorMessage(error: String) {
        AppToast.showShort(this@MainActivity,error)
    }

    override fun showProgress(show: Boolean) {
        if(show) pbar.visible()
        else pbar.inVisible()
    }

    override fun itemDetail(ownerInfo: RepoOwner, repo: Repo) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(EXTRA_OWNER, ownerInfo)
        intent.putExtra(EXTRA_REPO, repo)
        startActivity(intent)
    }

    fun injectDependency(){
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.contributeMainActivityInjector(this@MainActivity)
    }

    companion object{
        val EXTRA_OWNER = "owner"
        val EXTRA_REPO = "repo"
    }
}

