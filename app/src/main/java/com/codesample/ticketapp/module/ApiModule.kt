package com.codesample.ticketapp.module

import com.codesample.ticketapp.api.HomeAPI
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(HomeAPI::class.java)}
}