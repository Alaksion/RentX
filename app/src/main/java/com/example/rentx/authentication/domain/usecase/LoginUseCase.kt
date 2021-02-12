package com.example.rentx.authentication.domain.usecase

import android.app.Application
import com.example.rentx.authentication.data.model.UserModelData
import com.example.rentx.authentication.data.repositoy.AuthRepositoryImplementation
import com.example.rentx.shared.service.listeners.UseCaseListener
import com.example.rentx.shared.service.listeners.ValidationListener

class LoginUseCase(application: Application) {

    private val mRepository = AuthRepositoryImplementation(application)

    fun execute(
        email: String,
        password: String,
        listener: UseCaseListener<UserModelData>
    ) {
        val user: UserModelData? = mRepository.findUserByEmail(email)

        if (user == null) {
            listener.onError("Usuário não encontrado")
            return
        }

        if (user.password !== password) {
            listener.onError("Credenciais inválidas")
            return
        }

        listener.onSuccess(user)
    }
}