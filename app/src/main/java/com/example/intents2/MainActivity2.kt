package com.example.intents2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
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

        //Con esto guardamos ambos numeros en los datos del intent, para que la activity 1 se encargue de las comprobaciones
        intent.putExtra("numero1",numero1)
        intent.putExtra("numero2",numero2)

    }

    override fun onClick(p0: View?) {

        val resultado=etResultado.text.toString()

        //Con esto guardamos el resultado dado por el usuario en los datos del intent, para que la activity 1 se encargue de las comprobaciones
        intent.putExtra("resultado",resultado.toInt())

        //Con esto se indica que el resultado se ha dado correctamente
        setResult(Activity.RESULT_OK,intent)

        //Terminamos la activity
        finish()

    }

    /**
     * Funcion que escoge un numero aleatorio del 0 al 100
     */
    fun numeroAleatorio():Int {

        return (0..100).random()
    }


}