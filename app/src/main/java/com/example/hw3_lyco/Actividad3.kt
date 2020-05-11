package com.example.hw3_lyco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actividad2.*
import kotlinx.android.synthetic.main.activity_actividad3.*

class Actividad3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad3)
        button_volver.setOnClickListener { view ->
            abrirActividad2()
        }

    }
    fun abrirActividad2(){
        val intent = Intent(this, Actividad2::class.java)
        intent.putExtra("ptres", 1)
        startActivityForResult(intent, 10)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10) {
            //

        }
    }
}
