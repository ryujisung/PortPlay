package com.example.portplay

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import com.example.portplay.main.MainActivity
import com.example.portplay.signIn.SignInActivity
import com.example.portplay.signUp.SignUpActivity
import com.google.firebase.auth.FirebaseAuth

class IntroActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        auth = FirebaseAuth.getInstance()

        var handler = Handler()
        if(auth.currentUser != null){
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val txtSigninin =findViewById<TextView>(R.id.intro_txt_SignIn)
        txtSigninin.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        findViewById<Button>(R.id.intro_btn_SignUpStart).setOnClickListener {
            var intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        txtSigninin.setOnClickListener {
            var intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }

    }
}