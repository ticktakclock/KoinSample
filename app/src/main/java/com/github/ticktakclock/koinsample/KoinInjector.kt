package com.github.ticktakclock.koinsample

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module {
    single { Calculator() }
    single { CalculateService(get()) }
    viewModel { MainViewModel(get()) }
}