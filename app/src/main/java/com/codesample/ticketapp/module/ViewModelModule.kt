package com.codesample.ticketapp.module

import com.codesample.ticketapp.ui.main.MainViewModel
import com.codesample.ticketapp.ui.event.EventViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { EventViewModel() }
}