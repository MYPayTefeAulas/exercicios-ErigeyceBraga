package com.example.exercicioskotlin

import java.util.Random

class Dado (var lados:Int) {
    val random = Random()

    fun rolar():Int{
        return (1..lados).random() //random.nextInt(lados - 1)
    }
}

