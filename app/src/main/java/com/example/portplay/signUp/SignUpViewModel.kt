package com.example.portplay.signUp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.portplay.State
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class SignUpViewModel : ViewModel() {
    var auth = FirebaseAuth.getInstance()

    val nickname = MutableLiveData<String>()    // 닉네임
    val email = MutableLiveData<String>()       // 이메일
    val password = MutableLiveData<String>()    // 비밀번호
    val passwordRe = MutableLiveData<String>()  // 비밀번호 다시 입력
    val errorMessage = MutableLiveData<String?>()
    val state = MutableLiveData<State>()

    fun sigininAndSignup() : Boolean{
        var k = false
        auth?.createUserWithEmailAndPassword(email.value.toString(),password.value.toString())
            ?.addOnCompleteListener {
                    task ->
                if (task.isSuccessful){
                    state.value = State.SUCCESS
                    k = true
                }else if(task.exception?.message.isNullOrEmpty()){
                    Log.e("dd",task.exception?.message.toString())
                    state.value = State.FAIL
                }else{
                    sigininEmail()
                }
            }
        if(k){
            return true
        }else{
            return false
        }
    }
    fun sigininEmail(){
        auth?.createUserWithEmailAndPassword(nickname.toString(),password.toString())
            ?.addOnCompleteListener {
                    task ->
                if (task.isSuccessful){
                    if(task.result?.user!=null){
                        state.value = State.SUCCESS
                    }
                    else{
                        state.value = State.FAIL
                    }
                }else{
                    errorMessage.value = task.exception?.message
                    state.value = State.FAIL
                }
            }
    }

    fun inputEmailCheck() : Boolean{

        if (email.value.isNullOrBlank()) {
            return false
        }
        if(!Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", email.value)){
            return false
        }
        return true
    }
    fun inputPasswordCheck() : Boolean{

        if (password.value.isNullOrBlank()) {
            return false
        }
        return true
    }
    fun inputPasswordReCheck() : Boolean{

        if (password.value.isNullOrBlank() || password.value != passwordRe.value) {
            return false
        }
        return true
    }

    fun inputCheckEmailPassword(): Boolean {
        if (email.value.isNullOrBlank()) {
            return false
        }

        if (password.value.isNullOrBlank()) {
            return false
        }

        if (passwordRe.value.isNullOrBlank()) {
            return false
        }

        if (password.value != passwordRe.value) {
            return false
        }

        return true
    }

    fun inputCheckNameNickName(): Boolean {
        if (nickname.value.isNullOrBlank()) {
            return false
        }

        if (nickname.value!!.length !in 2..8) {
            return false
        }

        return true
    }
}