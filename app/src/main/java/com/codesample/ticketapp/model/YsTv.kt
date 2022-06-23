package com.codesample.ticketapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class YsTv(
    val tvCode: String,
    val tvFullImgUrl: String,
    val tvId: String,
    val tvImgType: String,
    val tvInputDate: String,
    val tvMetatagTitle: String,
    val tvNameMain: String,
    val tvVideoId: String,
    val tvVideoThumb: String,
    val tvVideoUrl: String,
    val tvViewCount: String
): Parcelable
