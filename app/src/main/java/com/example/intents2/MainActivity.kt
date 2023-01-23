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

    fun comprobarResultado(numero1:Int,numero2: Int,resultado:Int):Boolean {

        val test=numero1 + numero2

        return test==resultado
    }

    @Deprecated("Deprecated a partir de API 30")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) return

        if (data != null) {
            when (requestCode) {
                CALCULADORA -> {

                    val numero1=data.getIntExtra("numero1",0)
                    val numero2=data.getIntExtra("numero2",0)
                    val resultado=data.getIntExtra("resultado",0)


                    tvResultado.text=comprobarResultado(numero1,numero2,resultado).toString()


                }
                CAMARA -> {

                    val photo = data!!.extras!!["data"] as Bitmap?
                    ivFoto.setImageBitmap(photo)

                }


            }
        }
    }


    override fun onClick(view: View?) {
        when (view?.id) {

            btCamara.id -> {

                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, CAMARA)


            }
            btCalculo.id -> {

                val intent = Intent(this, MainActivity2::class.java)

                startActivityForResult(intent,CALCULADORA)

            }



        }


    }
}