package com.example.ugd3_kelompok10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import java.util.ResourceBundle.getBundle

class MainActivity : AppCompatActivity() {
    //Atribut yang akan kita pakai
    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private  lateinit var mainLayout: ConstraintLayout
    var  mBundle: Bundle? = null

    var tempUsername :String = "admin"
    var tempPassword : String ="admin"


    private lateinit var user: String
    private lateinit var pass: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(intent.getBundleExtra("login")!=null){
            getBundle()
            inputUsername.getEditText()?.setText(tempUsername)
            inputPassword.getEditText()?.setText(tempPassword)
        }

        //ubah Title pada App Bar Aplikasi
        setTitle("User Login")

        //hubungkan variabel dengan view di layoutnya
        inputUsername = findViewById(R.id.inputanLayoutUsername)
        inputPassword = findViewById(R.id.inputanLayoutPassword)
        mainLayout = findViewById(R.id.mainLayout)
        val btnRegister: Button = findViewById(R.id.btnRegister)
        val btnLogin: Button = findViewById(R.id.btnLogin)

        btnRegister.setOnClickListener(View.OnClickListener {
            val moveRegister = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(moveRegister)
        })

        //aksi pada btnLogin
        btnLogin.setOnClickListener(View.OnClickListener {
            var checkLogin = false
            val username: String = inputUsername.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()

            //pengecekan apakah inputan username kosong
            if (username.isEmpty()) {
                inputUsername.setError("Username must be filled with text")
                checkLogin = false
            }

            //pengecekan apakah inputan password kosong
            if (password.isEmpty()) {
                inputPassword.setError("Password must be filled with text")
                checkLogin = false
            }

            if(username==username&&password==password) checkLogin=true
            if (!checkLogin) return@OnClickListener
            val moveHome = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(moveHome)

        })

    }

    fun getBundle() {
        mBundle = intent.getBundleExtra("login")!!
        tempUsername = mBundle!!.getString("username")!!
        tempPassword = mBundle!!.getString("password")!!
    }
}