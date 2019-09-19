package com.github.ticktakclock.koinsample

class CalculateService(private val calculator: Calculator) {

    fun add(a: Int, b: Int): Int = calculator.sum(a, b)
}