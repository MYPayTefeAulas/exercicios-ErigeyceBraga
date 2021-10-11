package com.example.exercicioskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicioskotlin.databinding.ActivityListasBinding

class ListasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListasBinding

    private val frutas = listOf ("maça" , "mamao", "abacate")
    private val vegetais = listOf("pepino", "alface" , "pimentao")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListasBinding.inflate(layoutInflater)

        binding.btAnalisar.setOnClickListener {
            binding.txtSaida.text = analisar (binding.txtEntrada.text.toString())
        }

        setContentView(binding.root)
    }

    fun analisar(entrada: String):String {
        var saida = ""

        var encontrouAlimento = false

        for (fruta in frutas) {
            if (fruta == entrada) {
                saida = "É uma fruta"
                encontrouAlimento = true
                break
            }

        }
        for (vegetal in vegetais) {
            if (vegetal == entrada) {
                saida = "É um vegetal"
                encontrouAlimento = true
                break
            }

        }
        if (!encontrouAlimento){
            saida = "Não sei o que é isto"
        }

        return saida
    }
}