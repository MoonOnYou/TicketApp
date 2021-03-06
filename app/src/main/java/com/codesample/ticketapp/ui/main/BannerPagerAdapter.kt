package com.codesample.ticketapp.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.codesample.ticketapp.R
import com.codesample.ticketapp.constants.IntentKey
import com.codesample.ticketapp.databinding.ItemImageViewBinding
import com.codesample.ticketapp.extension.setImageUrl
import com.codesample.ticketapp.model.Banner
import com.codesample.ticketapp.ui.web_view.WebViewActivity


class BannerPagerAdapter(
    var context: Context,
    var items: ArrayList<Banner>? = arrayListOf()
) : PagerAdapter() {
    var listener: View.OnClickListener? = null

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = ItemImageViewBinding.inflate(LayoutInflater.from(container.context), container, false)
        val itemView: ImageView = binding.root.findViewById(R.id.imageViewBanner)
        if (items?.isNotEmpty() == true) {
            itemView.setImageUrl(items?.get(position)?.bannerImg)
        }
        itemView.setOnClickListener {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra(IntentKey.LINK, items?.get(position)?.bannerLink)
            context.startActivity(intent)
        }

        container.addView(binding.root)
        return binding.root
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun getCount(): Int {
        return items?.size ?: 0
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}

