package com.example.exercicioskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicioskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btTrocar.setOnClickListener {
            //binding.txtHello.text = novoTexto()
            //binding.txtHello.text = textoDaEntrada()
           // binding.txtHello.text = CalcularDobro()
           // binding.txtHello.text = Multiplicar()
            //binding.txtHello.text = calcular()
            binding.txtHello.text = calcularComWhen()
        }
        binding.btLimpar.setOnClickListener {
            binding.txtNumero1.text.clear()
            binding.txtNumero2.text.clear()
            binding.txtOperacao.text.clear()
            binding.txtHello.text = " "
        }

        setContentView(binding.root)
    }

    fun novoTexto (): String{
        return "Nvo texto de função"
    }

    fun textoDaEntrada(): String{
        return binding.txtNumero2.text.toString()
    }

    fun CalcularDobro(): String{
        var numeroStr = binding.txtNumero2.text.toString()
        val numero = numeroStr.toInt()
        val numeroDobro = numero * 2
        return numeroDobro.toString()
    }

    fun Multiplicar (): String{
        var numero1 = binding.txtNumero1.text.toString().toInt()
        var numero2 = binding.txtNumero2.text.toString().toInt()
        val resultado = numero1 * numero2
        return resultado.toString()
    }

    fun calcular (): String{
        val operacao = binding.txtOperacao.text.toString()
        val numero1 = binding.txtNumero1.text.toString().toInt()
        val numero2 = binding.txtNumero2.text.toString().toInt()
        var resultadoStr = ""
        if (operacao == "+") {
            resultadoStr = (numero1 + numero2).toString()
        }else if (operacao == "-"){
            resultadoStr = (numero1 - numero2).toString()
        }else{
            resultadoStr = "Operação não suportada"

        }
        return resultadoStr.toString()
    }

    fun calcularComWhen (): String{
        val operacao = binding.txtOperacao.text.toString()
        val numero1 = binding.txtNumero1.text.toString().toInt()
        val numero2 = binding.txtNumero2.text.toString().toInt()
        var resultadoStr = ""
        when(operacao) {
            "+" -> resultadoStr = (numero1 + numero2).toString()
            "-" -> resultadoStr = (numero1 - numero2).toString()
        else -> resultadoStr = "Operação não suportada"

        }
        return resultadoStr.toString()
    }
}