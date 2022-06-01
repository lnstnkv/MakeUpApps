package com.tsu.makeupapps.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tsu.makeupapps.registration.model.Email

class RegisterViewModel: ViewModel() {

    private val _isErrorEmail = MutableLiveData<Boolean>()
    val isErrorEmail: LiveData<Boolean>
        get() = _isErrorEmail

    private val _isErrorSamePassword = MutableLiveData<Boolean>()
    val isErrorSamePassword: LiveData<Boolean>
        get() = _isErrorSamePassword
    private val _isErrorPassword = MutableLiveData<Boolean>()
    val isErrorPassword: LiveData<Boolean>
        get() = _isErrorPassword
    private val checkingEmail = Email()

     fun checkEmail(email: String) {

        _isErrorEmail.value = checkingEmail.checkEmail(email)
    }

     fun samePassword(password: String, passwordRepeat: String) {
        if(password.length<8) _isErrorPassword.value=true
        _isErrorSamePassword.value = passwordRepeat.contentEquals(password)
    }
}