package com.r.values.authentic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variables
        val refUsers = FirebaseAuth.getInstance().currentUser
        val mAuth = FirebaseAuth.getInstance()
        val email = email_sign.text.toString()
        val password = password1.text.toString()


        btn_signup.setOnClickListener {


            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please enter text in the email or password field", Toast.LENGTH_LONG
                ).show()
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener() {
                        if (it.isSuccessful) {
                            val intent = Intent(this, Home::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(
                                this,
                                it.exception!!.message.toString(),
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                        memberslogin.setOnClickListener {
                            val loginscreen = Intent(this, Login::class.java)
                            startActivity(loginscreen)
                        }
                    }
            }
        }
    }
}
