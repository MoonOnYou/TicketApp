package com.codesample.ticketapp.ui.event

import androidx.lifecycle.MutableLiveData
import com.codesample.ticketapp.base.BaseViewModel
import com.codesample.ticketapp.model.Event

class EventViewModel: BaseViewModel() {
    val eventModel : MutableLiveData<Event> = MutableLiveData()

}