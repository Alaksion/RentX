package com.example.rentx.authentication.domain.usecase

import android.app.Application
import com.example.rentx.authentication.data.model.UserModelData
import com.example.rentx.authentication.data.repositoy.AuthRepositoryImplementation
import com.example.rentx.shared.service.listeners.UseCaseListener
import com.example.rentx.shared.service.listeners.ValidationListener
import com.example.rentx.shared.validators.EmailValidator

class CreateUserUseCase(application: Application) {

    private val mRepository = AuthRepositoryImplementation(application)

    fun execute(
        name: String,
        email: String,
        password: String,
        confirmPassword: String,
        listener: UseCaseListener<Long>
    ) {

        if(!isPasswordConfirmed(password, confirmPassword)){
            listener.onError("Senhas não coincidem")
            return
        }


        val user = UserModelData().apply {
            this.email = email
            this.name = name
            this.password = password
            this.id = 0
        }

        val createdUserId = mRepository.createUser(user)

        listener.onSuccess(createdUserId)
    }

    private fun isPasswordConfirmed(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }

}