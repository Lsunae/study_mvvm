package com.leesunae.study_mvvm.data.repository

interface Callback<T> {
    fun onSuccess(response: T)
    fun onFailure(message: String)
}