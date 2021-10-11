package com.example.exercicioskotlin.Agenda

import com.example.exercicioskotlin.Pessoa

class Agenda {
    private val listaAgenda = mutableListOf<AgendaPessoa>()
    private var indiceAtual = -1


    fun novoContato():Int{return indiceAtual}
    fun deletarContato(){
        listaAgenda.removeAt(indiceAtual)
        indiceAtual--
    }
    fun buscarContato(contato:String): AgendaPessoa {
        indiceAtual = 0
        for (lista in listaAgenda) {
            if(contato==lista.nome||contato==lista.telefone) return listaAgenda[indiceAtual]
            indiceAtual++
        }
        return listaAgenda[indiceAtual]
    }
    fun salvarContato(salvarPessoa: AgendaPessoa){
        listaAgenda.add(salvarPessoa)
        indiceAtual++
    }
    fun editarContato(contato: AgendaPessoa){
        listaAgenda[indiceAtual]=contato
    }
    fun proximoContato() : AgendaPessoa {
        if(indiceAtual == listaAgenda.size -1){
            indiceAtual = 0
        } else {
            indiceAtual++
        }
        return listaAgenda[indiceAtual]
    }
    fun verificarContato(contato: AgendaPessoa) :String{
        var testePessoaAg:String = "false"

        for (lista in listaAgenda) {
            if (lista.nome == contato.nome){
                testePessoaAg = contato.nome
                break
            }else if(lista.telefone == contato.telefone){
                testePessoaAg = contato.telefone
                break
            }
        }
        return testePessoaAg
    }
    fun listaVazia ():Boolean{
        return listaAgenda.size == 0
    }
    fun existenciaContato(nt:String): Boolean{
        for (lista in listaAgenda) {
            if(nt==lista.nome||nt==lista.telefone) return true
        }
        return false
    }

}