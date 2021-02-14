package com.example.rentx.domain.usecase

import android.app.Application
import com.example.rentx.data.model.UserModelData
import com.example.rentx.data.repository.AuthRepositoryImplementation
import com.example.rentx.shared.service.listeners.UseCaseListener

class LoginUseCase(application: Application) {

    private val mRepository =
        AuthRepositoryImplementation(
            application
        )

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

        if (user.password != password) {
            listener.onError("Credenciais inválidas")
            return
        }

        listener.onSuccess(user)
    }
}