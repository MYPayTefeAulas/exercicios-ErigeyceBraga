package com.example.exercicioskotlin.Agenda

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicioskotlin.databinding.ActivityAgendaBinding

class AgendaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaBinding
    private val agenda = Agenda()
    private var editar : Boolean = false
    private var contatoAtual = AgendaPessoa(nome = "",telefone = "0")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaBinding.inflate(layoutInflater)


        binding.agendaBtSalvar.setOnClickListener {

            val nome = binding.agendaTxtNom.text.toString()
            val telefone = binding.agendaTxtTelefone.text.toString()
            contatoAtual = AgendaPessoa(nome,telefone)


            if(binding.agendaTxtNom.text.toString() == "") {
                binding.agendaTxtSaida.text = "Nome vazio, digite o nome de um contato para apagá-lo"
                binding.agendaTxtSaida.setTextColor(Color.rgb(201,103,103))
            }else if (binding.agendaTxtTelefone.text.toString() == "" ){
                binding.agendaTxtSaida.text = "Telefone vazio, digite o telefone de um contato para apagá-lo"
                binding.agendaTxtSaida.setTextColor(Color.rgb(201,103,103))
            }else {
                if(agenda.verificarContato(contatoAtual)=="false") {
                    binding.agendaTxtSaida.text = "Contato salvo"
                    binding.agendaTxtSaida.setTextColor(Color.rgb(0,0,255))

                    agenda.salvarContato(contatoAtual)
                }else if(agenda.verificarContato(contatoAtual)==contatoAtual.nome&&editar==false) {
                    binding.agendaTxtSaida.text = "O nome ${contatoAtual.nome} já esta na lista"
                }else if(agenda.verificarContato(contatoAtual)==contatoAtual.telefone&&editar==false){
                    binding.agendaTxtSaida.text = "O telefone ${contatoAtual.telefone} já esta na lista"
                }else if(editar==true&&agenda.listaVazia()==false){
                    agenda.editarContato(contatoAtual)
                    binding.agendaTxtSaida.text = "Contato editado"
                }
            }
            editar = false
        }

        binding.agendaBtDeletar.setOnClickListener {
            if(binding.agendaTxtNom.text.toString() == "") {
                binding.agendaTxtSaida.text = "Nome vazio, CLIQUE EM PROXIMO ANTES DE DELETAR"
                binding.agendaTxtSaida.setTextColor(Color.rgb(201,103,103))
            }else if (binding.agendaTxtTelefone.text.toString() == "" ){
                binding.agendaTxtSaida.text = "Telefone vazio, CLIQUE EM PROXIMO ANTES DE DELETAR"
                binding.agendaTxtSaida.setTextColor(Color.rgb(201,103,103))
            }else if(editar==true){
                agenda.deletarContato()
                binding.agendaTxtSaida.text = "Contato deletado"
                binding.agendaTxtSaida.setTextColor(Color.rgb(0,0,255))
            }
            editar = false
        }

        binding.agendaBtProximo.setOnClickListener {
            if(agenda.listaVazia()==true){
                binding.agendaTxtSaida.text = "Agenda esta vazia"
                binding.agendaTxtSaida.setTextColor(Color.rgb(201,103,103))
            }else {
                contatoAtual = agenda.proximoContato()
                binding.agendaTxtNom.setText(contatoAtual.nome)
                binding.agendaTxtTelefone.setText(contatoAtual.telefone)
            }
            editar = true
            binding.agendaTxtSaida.text = "Contato ${agenda.novoContato()+1}"
            binding.agendaTxtSaida.setTextColor(Color.rgb(0,0,255))
        }

        binding.agendaBtBuscar.setOnClickListener {
            if(agenda.listaVazia()){
                binding.agendaTxtSaida.text = "Agenda esta vazia"
                binding.agendaTxtSaida.setTextColor(Color.rgb(201,103,103))
            }else if(agenda.existenciaContato(binding.agendaTxtBuscar.text.toString())) {
                contatoAtual = agenda.buscarContato(binding.agendaTxtBuscar.text.toString())
                binding.agendaTxtNom.setText(contatoAtual.nome)
                binding.agendaTxtTelefone.setText(contatoAtual.telefone)
                binding.agendaTxtSaida.text = "Contato ${agenda.novoContato()+1}"
                binding.agendaTxtSaida.setTextColor(Color.rgb(0,0,255))
                binding.agendaTxtResultado.text = "Nome: ${contatoAtual.nome}, telefone: ${contatoAtual.telefone}"
            }else {
                binding.agendaTxtSaida.text = "Este contato NÃO existe"
                binding.agendaTxtSaida.setTextColor(Color.rgb(201,103,103))
            }
            editar = true
            binding.agendaTxtBuscar.text.clear()
        }

        //binding.btAglista.setOnClickListener {
            //listaView
        //}

        setContentView(binding.root)
    }
}