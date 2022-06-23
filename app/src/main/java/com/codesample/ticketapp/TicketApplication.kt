package com.codesample.ticketapp

import android.app.Application
import com.codesample.ticketapp.module.apiModule
import com.codesample.ticketapp.module.networkModule
import com.codesample.ticketapp.module.viewModelModule
import com.codesample.ticketapp.util.SizeUtil
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TicketApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        SizeUtil.initWith(this)

        startKoin {
            androidContext(androidContext = this@TicketApplication)
            modules(apiModule + networkModule + viewModelModule)
        }
    }
}