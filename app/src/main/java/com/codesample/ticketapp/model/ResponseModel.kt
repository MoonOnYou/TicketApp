package com.codesample.ticketapp.model

data class ResponseModel(
    val results: Results,
    val serverCode: String,
    val serverMsg: String
)