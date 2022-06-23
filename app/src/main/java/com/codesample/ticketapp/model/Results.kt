package com.codesample.ticketapp.model

data class Results(
    val bannerList: ArrayList<Banner>,
    val displayTagList: ArrayList<DisplayTag>,
    val newEventList: ArrayList<NewEvent>,
    val recommendEventList: ArrayList<RecommendEvent>,
    val ysTvList: ArrayList<YsTv>
)