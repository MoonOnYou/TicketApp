package com.codesample.ticketapp.ui.video

import androidx.lifecycle.MutableLiveData
import com.codesample.ticketapp.base.BaseViewModel
import com.codesample.ticketapp.model.YsTv

class VideoViewModel: BaseViewModel() {
    val videoModel : MutableLiveData<YsTv> = MutableLiveData()

}