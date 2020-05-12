package com.r.values.authentic

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*
import kotlin.toString as kotlinToString

class Home: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //variables

        val username_disp = FirebaseAuth.getInstance().currentUser!!.email

        var welcome_user = username.text.toString()

        welcome_user = "Welcome$username_disp"
    }
}