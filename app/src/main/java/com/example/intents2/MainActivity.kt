package com.example.intents2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var btCalculo: Button
    private lateinit var btCamara: Button
    private lateinit var ivFoto: ImageView
    private lateinit var tvResultado: TextView



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

    override fun onClick(view: View?) {
        when (view?.id) {

            btCamara.id -> {



            }
            btCalculo.id -> {



            }



        }


    }
}