package com.codesample.ticketapp.model

data class DisplayTag(
    val createAdminId: Int,
    val createAt: String,
    val id: Int,
    val tagId: String,
    val tagLink: String,
    val tagName: String,
    val tagRank: Int,
    val updateAdminId: Int,
    val updatedAt: String
)