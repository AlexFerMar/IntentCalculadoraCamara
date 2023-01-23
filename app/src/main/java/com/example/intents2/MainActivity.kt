package com.example.intents2

import android.R.attr
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var btCalculo: Button
    private lateinit var btCamara: Button
    private lateinit var ivFoto: ImageView
    private lateinit var tvResultado: TextView

    private val CALCULADORA=1
    private val CAMARA=2



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivFoto=findViewById(R.id.ivFoto)
        tvResultado=findViewById(R.id.tvResultado)

        btCalculo = findViewById(R.id.btCalculadora)
        btCalculo.setOnClickListener(this)

        btCamara = findViewById(R.id.btCamara)
        btCamara.setOnClickListener(this)


    }

    /**
     * Funcion que comprueba si el resultado dado por el usuario es correcto
     * Devuelve un boolean indicando si ha acertado o no
     */

    fun comprobarResultado(numero1:Int,numero2: Int,resultado:Int):Boolean {

        val test=numero1 + numero2

        return test==resultado
    }

    /**
     * Funcion que recoge el resultado de los intent y realiza operaciones segun el intent que lo hay devuelto
     */
    @Deprecated("Deprecated a partir de API 30")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //Comprueba que la activiti haya terminado bien
        if (resultCode != Activity.RESULT_OK) return

        //Comprueba que la data del intent no sea nula
        if (data != null) {
            when (requestCode) {
                //Si el request code devuelto es el de la calculadora se ejecuta este bloque de codigo
                CALCULADORA -> {

                    val numero1=data.getIntExtra("numero1",0)
                    val numero2=data.getIntExtra("numero2",0)
                    val resultado=data.getIntExtra("resultado",0)


                    tvResultado.text=comprobarResultado(numero1,numero2,resultado).toString()


                }
                //Si el request code devuelto es el de la camara se ejecuta este bloque de codigo
                CAMARA -> {

                    val photo = data!!.extras!!["data"] as Bitmap?
                    ivFoto.setImageBitmap(photo)

                }


            }
        }
    }

    /**
     * Definimos los clickListener de los botones, dependiendo del id de cada boton el codigo se ejecutara de una forma u otra
     */
    override fun onClick(view: View?) {
        when (view?.id) {

            btCamara.id -> {
                //Llamamos el intent de la camara
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, CAMARA)


            }
            btCalculo.id -> {
                //Llamamos el intent de la calculadora
                val intent = Intent(this, MainActivity2::class.java)
                startActivityForResult(intent,CALCULADORA)

            }



        }


    }
}