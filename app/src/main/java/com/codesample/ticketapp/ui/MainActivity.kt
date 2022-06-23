package com.codesample.ticketapp.ui

import android.widget.Toast
import androidx.viewpager.widget.ViewPager
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
        setUpCurrentPageListener()
    }

    private fun getData() {
        mViewModel.getHomeData({
            setupBannerAdapter()
            Toast.makeText(this,"성공", Toast.LENGTH_SHORT).show()
        }, {
            Toast.makeText(this,"$it", Toast.LENGTH_SHORT).show()
        })
    }

    private fun disableRecyclerViewScroll() {
        mViewDataBinding.recyclerViewEvent.isNestedScrollingEnabled = false
    }

    private fun setupBannerAdapter() {
        val adapter = BannerPagerAdapter(mViewModel.bannerList.value)
        mViewDataBinding.viewPagerBanner.adapter = adapter
        val totalPage = mViewModel.bannerList.value?.size
        mViewDataBinding.textViewBannerTotalIndex.text = "/ $totalPage"
    }

    private fun setUpCurrentPageListener() {
        mViewDataBinding.viewPagerBanner.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                val currentPage = position + 1
                val totalPage = mViewModel.bannerList.value?.size
                mViewDataBinding.textViewBannerIndex.text = "$currentPage"
                mViewDataBinding.textViewBannerTotalIndex.text = "/ $totalPage"
            }
        })
    }
}