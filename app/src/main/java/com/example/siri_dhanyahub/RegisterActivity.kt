package com.example.siri_dhanyahub

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        val name = findViewById<EditText>(R.id.etName)
        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)
        val confirmPassword =
            findViewById<EditText>(R.id.etConfirmPassword)

        val registerBtn =
            findViewById<Button>(R.id.btnRegister)

        val loginText =
            findViewById<TextView>(R.id.tvLogin)

        registerBtn.setOnClickListener {

            if (
                password.text.toString()
                != confirmPassword.text.toString()
            ) {

                Toast.makeText(
                    this,
                    "Passwords do not match",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                sharedPreferences.edit()
                    .putString("name", name.text.toString())
                    .putString("email", email.text.toString())
                    .putString("password", password.text.toString())
                    .apply()

                Toast.makeText(
                    this,
                    "Registration Successful",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(this, LoginActivity::class.java)
                )

                finish()
            }
        }

        loginText.setOnClickListener {

            startActivity(
                Intent(this, LoginActivity::class.java)
            )
        }
    }
}