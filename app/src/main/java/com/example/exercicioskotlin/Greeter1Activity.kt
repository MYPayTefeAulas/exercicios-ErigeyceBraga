package com.example.exercicioskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicioskotlin.databinding.ActivityGreeter1Binding

class Greeter1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGreeter1Binding
    private val listaNomes = mutableListOf<String>()
    private var indiceAtual = 0
    private lateinit var greeterAtual: GreeterTipo1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGreeter1Binding.inflate(layoutInflater)

        //------------------------------------------------
        //configuração de variaveis "globais" da tela
        val greeter1 = GreeterTipo1("Ola")
        val greeter2 = GreeterTipo1("Bem Vindo,")
        greeterAtual = greeter1
        listaNomes.add("Erigeyce")
        listaNomes.add("Stephen")
        listaNomes.add("Angelo")

        //------------------------------------------------
        //configuração dos botões

        binding.btImprimir.setOnClickListener {
            val nomeAtual = listaNomes[indiceAtual]

            binding.txtSaida.text = greeterAtual.greet(nomeAtual)


                if (indiceAtual == listaNomes.size - 1){
                    indiceAtual = 0
                } else {
                    indiceAtual++
                }
            }



        binding.btTrocar.setOnClickListener {
            if (greeterAtual == greeter1){
                greeterAtual = greeter2
                binding.txtNumGreeter.text = "2"
            }else{
                greeterAtual = greeter1
                binding.txtNumGreeter.text = "1"
            }
        }

        setContentView(binding.root)
    }
}