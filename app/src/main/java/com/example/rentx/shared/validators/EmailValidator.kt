package com.example.rentx.shared.validators

class EmailValidator {

    companion object{
        fun validate(email : String) : Boolean {
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

            return email.trim().matches(Regex(emailPattern))
        }
    }
}