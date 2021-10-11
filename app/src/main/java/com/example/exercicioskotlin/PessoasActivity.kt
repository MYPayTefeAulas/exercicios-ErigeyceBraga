package com.example.exercicioskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicioskotlin.databinding.ActivityListasBinding
import com.example.exercicioskotlin.databinding.ActivityPessoasBinding

class PessoasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPessoasBinding

    private var nome = ""
    private var idade = 0

    private val listaPessoas = mutableListOf<Pessoa>()
    private var indiceAtual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPessoasBinding.inflate(layoutInflater)

        binding.btImprimir.setOnClickListener {
            binding.txtSaida.text = imprimePessoa()
        }

        binding.btSalvarpessoa.setOnClickListener {
            nome = binding.txtNomepessoa.text.toString()
            binding.txtNomepessoa.text.clear()
            idade = binding.txtIdadepessoa.text.toString().toInt()
            binding.txtIdadepessoa.text.clear()

            val pessoa = Pessoa(nome,idade)
            listaPessoas.add(pessoa)
        }

        setContentView(binding.root)
    }

    fun imprimePessoa(): String{
        if (indiceAtual >= listaPessoas.size)
            indiceAtual = 0
        val pessoaAtual = listaPessoas[indiceAtual]
        indiceAtual++
        return "Nome: ${pessoaAtual.nome}, Idade: ${pessoaAtual.idade}"
    }
}