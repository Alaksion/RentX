package com.example.rentx.authentication.domain.usecase

import android.app.Application
import com.example.rentx.authentication.data.model.UserModelData
import com.example.rentx.authentication.data.repositoy.AuthRepositoryImplementation
import com.example.rentx.shared.service.listeners.UseCaseListener
import com.example.rentx.shared.service.listeners.ValidationListener
import com.example.rentx.shared.validators.EmailValidator

class ValidateDuplicatedMailUseCase(application: Application) {

    private val mRepository = AuthRepositoryImplementation(application)

    fun execute(email: String, listener: UseCaseListener<Long>) {

        if(!EmailValidator.validate(email)){
            listener.onError("E-mail em formato inválido")
            return
        }

        val findUsedEmail: UserModelData? = this.mRepository.findUserByEmail(email)

        if (findUsedEmail != null) {
            listener.onError("E-mail já está em uso")
            return
        }

        listener.onSuccess(1)
    }
}