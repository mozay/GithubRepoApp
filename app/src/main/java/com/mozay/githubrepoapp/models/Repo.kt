package com.mozay.githubrepoapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Repo(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("language") val language: String?,
    @SerializedName("stargazers_count") val stargazers_count: Int,
    @SerializedName("open_issues_count") val open_issues_count: Int,
    @SerializedName("forks_count") val forks_count: Int,
    @SerializedName("owner") val owner: RepoOwner?
) : Serializable