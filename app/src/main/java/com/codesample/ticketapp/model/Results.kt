package com.codesample.ticketapp.model

data class Results(
    val bannerList: ArrayList<Banner>,
    val displayTagList: ArrayList<DisplayTag>,
    val newEventList: ArrayList<Event>,
    val recommendEventList: ArrayList<Event>,
    val ysTvList: ArrayList<YsTv>
)