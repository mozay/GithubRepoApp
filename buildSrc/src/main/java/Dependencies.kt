@file:Suppress("SpellCheckingInspection")

/**
 * Developed by skydoves on 2018-02-17.
 * Copyright (c) 2018 skydoves rights reserved.
 */

@Suppress("unused", "MayBeConstant")
object Dependencies {
    val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val junit = "junit:junit:${Versions.junit}"
    val support_appcompat = "androidx.appcompat:appcompat:${Versions.accompat}"
    val livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.livedataKtx}"
    val support_design = "com.google.android.material:material:${Versions.material}"
    val support_cardview = "androidx.cardview:cardview:${Versions.androidx}"
    val support_recyclerview = "androidx.recyclerview:recyclerview:${Versions.androidx}"
    val support_constraintlayout = "com.android.support.constraint:constraint-layout:${Versions.androidx}"
    val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val anko = "org.jetbrains.anko:anko:${Versions.anko}"
    val arch_lifecycle = "android.arch.lifecycle:extensions:${Versions.archComponent}"
    val arch_core_testing = "android.arch.core:core-testing:${Versions.archCoreTesting}"
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    val dagger_android_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val dagger_android_compiler = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitAdapter =  "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    val multiDex = "com.android.support:multidex:${Versions.multiDex}"
}