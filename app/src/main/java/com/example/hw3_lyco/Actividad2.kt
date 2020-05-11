package com.example.hw3_lyco

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actividad2.*
import kotlinx.android.synthetic.main.activity_actividad2.button
import kotlinx.android.synthetic.main.activity_main.*
import java.io.PrintStream
import java.util.*

class Actividad2 : AppCompatActivity() {

    val listado = arrayListOf<String>()

    var cuenta_palabras =5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        val parametro1 = intent.getStringExtra("puno")
       // val parametro3 = (intent.getStringExtra("ptres")).toInt()
        //mensaje.setText(parametro1)
       /* if(parametro3 == 1){
            Toast.makeText(this, "LEYO EL PARAMETRO TRES", Toast.LENGTH_SHORT).show()
            reinicio()
        }*/
        val nuevo = findViewById(R.id.editText) as EditText
        button.setOnClickListener { view ->
            when (cuenta_palabras) {
                0 -> abrirActividad3()
                in 1..5 ->  escribe_archivo(nuevo.text.toString())
                else -> println("Ni el uno, ni el otro, jeje")
            }
            }
        }

    fun abrirActividad3(){
        val intent = Intent(this, Actividad3::class.java)
        intent.putExtra("puno", "Vamos por la 3!!!")
        startActivityForResult(intent, 10)
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10) {
            //
        }
    }
    fun escribe_archivo(palabra: String){
        val salida = PrintStream(openFileOutput("palabras.txt", Context.MODE_APPEND ))
        //val salida = Scanner(getResources().openRawResource(R.raw.palabras))
        salida.println(",$palabra")
        cuenta_palabras = cuenta_palabras - 1
        val ayuda = findViewById(R.id.cantidad_words) as TextView
        ayuda.setText("Quedan ($cuenta_palabras) palabras!")
        salida.close()
    }
    fun reinicio(){
        Toast.makeText(this, "ESTAMOS REINICIANDOOOO", Toast.LENGTH_SHORT).show()
        cuenta_palabras =5
        val salida = Scanner(openFileInput("palabras.txt"))
        salida.remove()
        salida.close()
    }
    fun Larchivo(){
        val entrada = Scanner ( openFileInput("palabras.txt"))

        while(entrada.hasNextLine()) {
            val linea = entrada.nextLine()
            listado.addAll(linea.split(","))
        }
        entrada.close()
    }

}

