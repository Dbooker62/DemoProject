package com.example.daniel

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*


class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
    constructor(val intValue: Int) {
        login(1),
        password(2),
        success(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TxtLogin = findViewById<TextView>(R.id.editTextTextPersonName);
        val TxtPass = findViewById<TextView>(R.id.editTextTextPersonName2);
        val Btn = findViewById<Button>(R.id.button);

        Btn.setOnClickListener {
            when(CheckLogin(TxtLogin.text.toString() , TxtPass.text.toString())){

                LoginSuccess.login -> {
                    Toast.makeText(applicationContext , getString(R.string.errLogin) , LENGTH_LONG).show()
                    TxtLogin.requestFocus()

                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext , getString(R.string.errPass) , LENGTH_LONG).show()
                    TxtPass.requestFocus()
                }

                else ->
                {
                    Toast.makeText(applicationContext , "Success" , LENGTH_LONG).show()
                }
            }
        }


    }

    fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess{
        val holdLogin = "Daniel"
        val holdPass = "Booker"

        if(holdLogin != txtLogin){
            return LoginSuccess.login
        }
        return if (holdPass != txtPassword){
            LoginSuccess.password

        } else LoginSuccess.success
    }



}