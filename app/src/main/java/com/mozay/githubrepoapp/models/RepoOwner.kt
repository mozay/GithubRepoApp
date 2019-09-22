package com.mozay.githubrepoapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RepoOwner(
    @SerializedName("id") val id: Long,
    @SerializedName("login") val login: String?,
    @SerializedName("avatar_url") val avatar_url: String?,
    @SerializedName("url") val url: String?
) : Serializable