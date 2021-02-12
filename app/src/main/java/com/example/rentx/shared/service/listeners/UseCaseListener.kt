package com.example.rentx.shared.service.listeners

interface UseCaseListener<T> {

    fun onSuccess(response : T)
    fun onError(message: String)
}