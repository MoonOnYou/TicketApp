package com.codesample.ticketapp.ui

import androidx.lifecycle.MutableLiveData
import com.codesample.ticketapp.api.HomeAPI
import com.codesample.ticketapp.base.BaseViewModel
import com.codesample.ticketapp.extension.with
import com.codesample.ticketapp.model.*
import retrofit2.HttpException


class MainViewModel(val homeAPI: HomeAPI) : BaseViewModel() {
    var bannerList: MutableLiveData<ArrayList<Banner>?> = MutableLiveData(arrayListOf())
    var tagList: MutableLiveData<ArrayList<DisplayTag>?> = MutableLiveData(arrayListOf())
    var eventList: MutableLiveData<ArrayList<RecommendEvent>?> = MutableLiveData(arrayListOf())
    var newtList: MutableLiveData<ArrayList<NewEvent>?> = MutableLiveData(arrayListOf())
    var tvtList: MutableLiveData<ArrayList<YsTv>?> = MutableLiveData(arrayListOf())

    fun getHomeData(
        complete: (() -> Unit)? = null,
        fail: ((String?) -> Unit)? = null
    ) {
        addCompositeDisposable(homeAPI.getDealList().with().subscribe({
            if (it.isSuccessful) {
                bannerList.value = it.body()?.results?.bannerList
                tagList.value = it.body()?.results?.displayTagList
                eventList.value = it.body()?.results?.recommendEventList
                newtList.value = it.body()?.results?.newEventList
                tvtList.value = it.body()?.results?.ysTvList
                complete?.invoke()
            } else {
                fail?.invoke(it.message())
            }
        }, {
            if (it is HttpException) fail?.invoke(it.message())
            else fail?.invoke("ㅜ_ㅜ fail")
        }))
    }
}