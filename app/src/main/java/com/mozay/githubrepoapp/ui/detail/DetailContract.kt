package com.mozay.githubrepoapp.ui.detail

import com.mozay.githubrepoapp.ui.base.BaseContract

class DetailContract {

    interface View: BaseContract.View {
        fun showMessage(success: Byte)
    }

    interface Presenter: BaseContract.Presenter<DetailContract.View> {
        //todo:favourite
    }

}