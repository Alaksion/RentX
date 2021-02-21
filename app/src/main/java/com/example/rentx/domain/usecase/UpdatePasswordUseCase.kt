package com.example.rentx.domain.usecase

import android.app.Application
import com.example.rentx.data.model.UserModelData
import com.example.rentx.data.repository.UserRepositoryImplementation
import com.example.rentx.shared.service.listeners.UseCaseListener
import java.lang.Exception


class UpdatePasswordUseCase(application: Application) {

    private val mRepository = UserRepositoryImplementation(application)

    fun execute(
        password: String,
        confirmPassword: String,
        userId: Long,
        listener: UseCaseListener<Unit>
    ) {
        if(password != confirmPassword){
            listener.onError("Senhas não coincidem")
            return
        }

        val user : UserModelData? = mRepository.findUserById(userId)

        if(user == null){
            listener.onError("Usuário não encontrado")
            return
        }

        user.password = password

        saveUser(user)
        listener.onSuccess(Unit)
    }

    private fun saveUser(userModelData: UserModelData){
        try {
            mRepository.updatePassword(userModelData)
        } catch (e : Exception){
            print(e.stackTrace)
            throw e
        }
    }
}
