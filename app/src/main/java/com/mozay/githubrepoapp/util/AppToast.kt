package com.mozay.githubrepoapp.util

import android.content.Context
import android.widget.Toast

class AppToast {
    companion object{
        fun showShort(context: Context, message: String){
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
        }

        fun showLong(context: Context, message: String){
            Toast.makeText(context,message,Toast.LENGTH_LONG).show()
        }
    }
}