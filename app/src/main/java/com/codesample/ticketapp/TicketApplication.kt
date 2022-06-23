package com.codesample.ticketapp

import android.app.Application
import com.codesample.ticketapp.module.apiModule
import com.codesample.ticketapp.module.networkModule
import com.codesample.ticketapp.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TicketApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(androidContext = this@TicketApplication)
            modules(apiModule + networkModule + viewModelModule)
        }
    }
}