package com.example.assignment3kotlin

import android.content.Intent
import android.*
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.TextValueSanitizer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    private var notificationId1 :Int = 123
    private val channelId = "App_Channel.testNotification"
    private val description = "Rama Notification "
    private fun basicNotification() {
        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.mipmap.logo)
            .setContentTitle("HW notification")
            .setContentText("This is Rama HW ")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(this)) {
            notify(notificationId1, builder.build())
        }
    }
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "HW notification"
            val descriptionText = description
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var txt: TextView= findViewById(R.id.midText)

        val bundle: Bundle?= intent.extras

        val lBtn: Button= findViewById(R.id.btn)
        lBtn.setOnClickListener{
            createNotificationChannel()
            basicNotification()

            val loginIntent= Intent(this, UserLoginPage2::class.java)
            startActivity(loginIntent)
            }

        bundle?.let {
            lBtn.visibility= View.INVISIBLE
            val mssg= bundle.getString("msg")
            txt.text= "Welcome " + mssg
            Toast.makeText(this, mssg, Toast.LENGTH_LONG).show()


        }

    }
}