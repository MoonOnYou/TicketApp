package com.codesample.ticketapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.codesample.ticketapp.R
import com.codesample.ticketapp.base.BaseActivity
import com.codesample.ticketapp.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    private val mViewModel : MainViewModel by inject()

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreated() {
        getData()
        disableRecyclerViewScroll()
    }

    private fun getData() {
        mViewModel.getHomeData({
            Toast.makeText(this,"성공", Toast.LENGTH_SHORT).show()
        }, {
            Toast.makeText(this,"$it", Toast.LENGTH_SHORT).show()
        })
    }

    private fun disableRecyclerViewScroll() {
        mViewDataBinding.recyclerViewEvent.isNestedScrollingEnabled = false
    }

}