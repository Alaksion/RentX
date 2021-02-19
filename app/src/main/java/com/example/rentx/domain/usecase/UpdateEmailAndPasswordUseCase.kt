package com.example.rentx.domain.usecase

import android.app.Application
import com.example.rentx.data.model.UserModelData
import com.example.rentx.data.repository.AuthRepositoryImplementation
import com.example.rentx.data.repository.UserRepositoryImplementation
import com.example.rentx.shared.service.listeners.UseCaseListener
import com.example.rentx.shared.validators.EmailValidator
import java.lang.Exception


class UpdateEmailAndPasswordUseCase(application: Application) {

    private var mUserRepository = UserRepositoryImplementation(application)
    private var mAuthRepository = AuthRepositoryImplementation(application)

    fun execute(userId: Long, email: String, userName: String, listener: UseCaseListener<UserModelData>){

        val loggedUser = mUserRepository.findUserById(userId)

        val findUserWithSameMail : UserModelData? = mAuthRepository.findUserByEmail(email)

        if(!EmailValidator.validate(email)){
            listener.onError("E-mail inválido")
            return
        }

        if(findUserWithSameMail != null && findUserWithSameMail.id != userId) {
            listener.onError("E-mail já está em uso")
            return
        }

        loggedUser.email = email
        loggedUser.name = userName

        saveUser(loggedUser)
        listener.onSuccess(loggedUser)
    }

    private fun saveUser(userModelData: UserModelData){
        try {
            mUserRepository.updateEmailAndUsername(userModelData)
        } catch (e : Exception){
            print(e.stackTrace)
            throw e
        }

    }
}