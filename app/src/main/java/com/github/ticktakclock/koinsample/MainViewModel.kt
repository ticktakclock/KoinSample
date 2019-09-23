package com.github.ticktakclock.koinsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val calculateService: CalculateService) : ViewModel() {

    private var _result: MutableLiveData<String> = MutableLiveData()

    private var _a: MutableLiveData<String> = MutableLiveData()
    private var _b: MutableLiveData<String> = MutableLiveData()

    val result: LiveData<String>
        get() = _result
    val a: MutableLiveData<String>
        get() = _a
    val b: MutableLiveData<String>
        get() = _b

    fun calculate(a: String?, b: String?) {
        val numA = if (a.isNullOrEmpty()) 0 else a.toInt()
        val numB = if (b.isNullOrEmpty()) 0 else b.toInt()
        val result = calculateService.sum(numA, numB).toString()
        _result.value = result
    }
}