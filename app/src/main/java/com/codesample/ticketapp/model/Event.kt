package com.codesample.ticketapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val comment: String,
    val cpmBudgetScore: Double,
    val currencyName: String,
    val customerCode: String,
    val customerName: String,
    val detailLinkUrl: String,
    val displayName: String,
    val distance: Int,
    val locationName: String,
    val name: String,
    val price: Int,
    val productCode: String,
    val rateScore: Int,
    val reservationYn: String,
    val reviewCount: Int,
    val score: Int,
    val thumbnailImageUrl: String,
    val wishCount: Int,
    val wishIcon: String
): Parcelable
