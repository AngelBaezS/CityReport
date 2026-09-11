package com.upiicsa.cityreport

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.upiicsa.cityreport.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvBienvenida.text = "¡Bienvenido a CityReport!"
        binding.btnEmpezar.setOnClickListener {
            Log.d("CityReport", "Botón presionado 🚀")
        }
    }
}
