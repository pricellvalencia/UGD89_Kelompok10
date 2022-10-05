package com.example.ugd3_kelompok10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class EditProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)

        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener(View.OnClickListener {
            val moveRegister = Intent(this@EditProfilActivity, HomeActivity::class.java)
            startActivity(moveRegister)
        })
    }
}