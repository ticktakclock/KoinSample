package com.github.ticktakclock.koinsample

class CalculateService(private val calculator: Calculator) {

    fun sum(a: Int, b: Int): Int = calculator.sum(a, b)
}