package com.example.exercicioskotlin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicioskotlin.Greeter.Greeter1Activity
import com.example.exercicioskotlin.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialBinding.inflate(layoutInflater)

        binding.btAbrirExListas.setOnClickListener {
            val intent = Intent(this@TelaInicialActivity, ListasActivity::class.java)
            startActivity(intent)
        }

        binding.btAbrirExPessoas.setOnClickListener {
            val intent = Intent(this@TelaInicialActivity, PessoasActivity::class.java)
            startActivity(intent)
        }

        binding.btAbrirExercicioGreeter.setOnClickListener {
            val intent = Intent(this@TelaInicialActivity, Greeter1Activity::class.java)
            startActivity(intent)
        }

        binding.btAbrirExSorteio.setOnClickListener {
            val intent = Intent(this@TelaInicialActivity, SorteioActivity::class.java)
            startActivity(intent)
        }

        binding.txtTitulo.setTextColor(Color.rgb(201, 103,103))

        setContentView(binding.root)
    }
}