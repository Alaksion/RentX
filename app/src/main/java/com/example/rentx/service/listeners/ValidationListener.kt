package com.example.rentx.service.listeners

class ValidationListener(string: String = ""){

    private var message : String = ""
    private var success : Boolean = false

    init {
        this.message = string
        this.success = string.isNotEmpty()
    }

    fun getResult() : Boolean{
        return this.success
    }

    fun getMessage(): String{
        return this.message
    }

}
