package com.codesample.ticketapp.ui

import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.ContextThemeWrapper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import androidx.viewpager.widget.ViewPager
import com.codesample.ticketapp.PeekingLinearLayoutManager
import com.codesample.ticketapp.R
import com.codesample.ticketapp.base.BaseActivity
import com.codesample.ticketapp.databinding.ActivityMainBinding
import com.codesample.ticketapp.util.SizeUtil
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
            setupVideoAdapter()
            setupEventAdapter()
            setupTag()
            Toast.makeText(this,"성공", Toast.LENGTH_SHORT).show()
        }, {
            Toast.makeText(this,"$it", Toast.LENGTH_SHORT).show()
        })
    }

    private fun disableRecyclerViewScroll() {
        mViewDataBinding.recyclerViewEvent.isNestedScrollingEnabled = false
    }

    private fun setupTag() {
        mViewModel.getTagName()
        val tags = mViewModel.tagNameList.value
        if (tags != null) {
            for (tag in tags) {
                mViewDataBinding.layoutFlexbox.addView(makeChipTextView(tag))
            }
        }
    }

    private fun setupEventAdapter() {
        val adapter = EventAdapter(mViewModel.eventList.value)
        mViewDataBinding.recyclerViewEvent.adapter = adapter
        val newAdapter = NewEventAdapter(mViewModel.newList.value)
        mViewDataBinding.recyclerViewNewEvent.adapter = newAdapter
    }

    private fun makeChipTextView(tag : String) : TextView {
        val textView = TextView(ContextThemeWrapper(this, R.style.Theme_AppCompat_DayNight_NoActionBar))
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val margin4 = SizeUtil.convertDpToPixel(4f).toInt()
        val padding2 = SizeUtil.convertDpToPixel(2f).toInt()
        val padding4 = SizeUtil.convertDpToPixel(4f).toInt()
        params.setMargins(margin4, margin4, margin4, margin4)
        textView.layoutParams = params
        textView.setPadding(padding4, padding2, padding4, padding2)
        textView.setBackgroundColor(getColor(R.color.pink1))
        textView.setTextColor(getColor(R.color.pink4))
        textView.text = tag

        return textView
    }

    private fun setupVideoAdapter() {
        val adapter = VideoAdapter(mViewModel.tvtList.value)
        mViewDataBinding.recyclerViewVideo.layoutManager = PeekingLinearLayoutManager(this)
        mViewDataBinding.recyclerViewVideo.adapter = adapter

        // 한칸 씩 이동하게 설정
        val snapHelper: SnapHelper = PagerSnapHelper()
        if (mViewDataBinding.recyclerViewVideo.onFlingListener == null) snapHelper.attachToRecyclerView(mViewDataBinding.recyclerViewVideo)
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