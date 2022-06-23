package com.codesample.ticketapp.ui.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codesample.ticketapp.R
import com.codesample.ticketapp.base.BaseActivity
import com.codesample.ticketapp.constants.IntentKey
import com.codesample.ticketapp.databinding.ActivityEventBinding
import com.codesample.ticketapp.extension.setImageUrl
import org.koin.android.ext.android.inject

class EventActivity : BaseActivity<ActivityEventBinding, EventViewModel>() {
    private val mViewModel : EventViewModel by inject()

    override fun getLayoutId(): Int {
        return R.layout.activity_event
    }

    override fun onCreated() {
        getData()
    }

    private fun getData() {
        mViewModel.eventModel.value = intent.getParcelableExtra(IntentKey.EVENT)
        mViewDataBinding.imageView.setImageUrl(mViewModel.eventModel.value?.thumbnailImageUrl)
        mViewDataBinding.textViewCustomerName.text = mViewModel.eventModel.value?.customerName
        mViewDataBinding.textViewName.text = mViewModel.eventModel.value?.name
        mViewDataBinding.textViewComment.text = mViewModel.eventModel.value?.comment
        mViewDataBinding.textViewPrice.text = "${mViewModel.eventModel.value?.price.toString()}원"
    }
}