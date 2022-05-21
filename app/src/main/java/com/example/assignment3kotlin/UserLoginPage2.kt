package com.example.assignment3kotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class UserLoginPage2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login_page)

        val loginButton : Button = findViewById(R.id.LoginBtn)
        val mail: EditText= findViewById(R.id.LoginEmail)

        loginButton.setOnClickListener{
            val homeIntent= Intent(this, MainActivity::class.java).apply {
                putExtra("msg",mail.text.toString())
            }
            startActivity(homeIntent)
        }

    }
}