package com.example.intents2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity(),View.OnClickListener {


    private lateinit var btComprobar: Button
    private lateinit var etResultado: EditText
    private lateinit var tvCuenta: TextView

    private val numero1=numeroAleatorio()
    private val numero2=numeroAleatorio()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        etResultado=findViewById(R.id.etResultado)

        tvCuenta=findViewById(R.id.tvCuenta)
        tvCuenta.text="$numero1 + $numero2"

        btComprobar = findViewById(R.id.btComprobar)
        btComprobar.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {





    }


    fun numeroAleatorio():Int {

        return (0..100).random()
    }


}