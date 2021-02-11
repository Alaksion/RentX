package com.example.rentx.authentication.domain.usecase

import android.app.Application
import com.example.rentx.authentication.data.model.UserModelData
import com.example.rentx.authentication.data.repositoy.AuthRepositoryImplementation
import com.example.rentx.shared.service.listeners.ValidationListener
import com.example.rentx.shared.validators.EmailValidator

class ValidateDuplicatedMailUseCase(application: Application) {

    private val mRepository = AuthRepositoryImplementation(application)

    fun execute(email: String): ValidationListener {

        if(!EmailValidator.validate(email)){
            return ValidationListener("E-mail em formato inválido")
        }

        val findUsedEmail: UserModelData? = this.mRepository.findUserByEmail(email)

        if (findUsedEmail != null) {
            return ValidationListener("Email já está em uso")
        }

        return ValidationListener()
    }
}