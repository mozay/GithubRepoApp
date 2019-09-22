package com.mozay.githubrepoapp.util

fun String.validateString() : Boolean{
    return !(trim().isNullOrEmpty())
}