package com.example.exercicioskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicioskotlin.databinding.ActivitySorteioBinding

class SorteioActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySorteioBinding
    private val listaSorteio = mutableListOf<Dado>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySorteioBinding.inflate(layoutInflater)
        listaSorteio.add(Dado(4))
        listaSorteio.add(Dado(6))
        listaSorteio.add(Dado(8))


        binding.btTrocarLado1.setOnClickListener {
            listaSorteio[0].lados = trocarDados(listaSorteio[0].lados)
            binding.txtLado1.text = "${listaSorteio[0].lados} lados"

        }
        binding.btTrocarLado2.setOnClickListener {
            listaSorteio[1].lados = trocarDados(listaSorteio[1].lados)
            binding.txtLado2.text = "${listaSorteio[1].lados} lados"
        }
        binding.btTrocarLado3.setOnClickListener {
            listaSorteio[2].lados = trocarDados(listaSorteio[2].lados)
            binding.txtLado3.text = "${listaSorteio[2].lados} lados"
        }

        binding.btSortear.setOnClickListener {
            binding.txtSaida1.text = listaSorteio[0].rolar().toString()
            binding.txtSaida2.text = listaSorteio[1].rolar().toString()
            binding.txtSaida3.text = listaSorteio[2].rolar().toString()
        }
        setContentView(binding.root)
    }

    fun trocarDados(lado:Int):Int {
        if (lado>=4 && lado<=8){
            return (lado + 2)
        }else {
            return 4
        }
    }
}
