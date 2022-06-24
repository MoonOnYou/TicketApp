package com.codesample.ticketapp.ui.web_view

import androidx.lifecycle.MutableLiveData
import com.codesample.ticketapp.base.BaseViewModel

class WebViewViewModel : BaseViewModel() {
    val link : MutableLiveData<String> = MutableLiveData()
}