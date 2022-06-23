package com.codesample.ticketapp.ui.main
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codesample.ticketapp.R
import com.codesample.ticketapp.base.BaseViewHolder
import com.codesample.ticketapp.databinding.ItemVideoBinding
import com.codesample.ticketapp.extension.setImageUrl
import com.codesample.ticketapp.model.YsTv

class VideoAdapter(
    var items : ArrayList<YsTv>?
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var clickListener : View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return VideoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is VideoViewHolder) itemView(holder, position)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    private fun itemView(holder: VideoViewHolder, position: Int) {
        holder.binding.imageView.setImageUrl(items?.get(position)?.tvFullImgUrl)
        holder.binding.textViewTitle.text = items?.get(position)?.tvNameMain
        holder.binding.textViewViewCount.text = "조회수 ${items?.get(position)?.tvViewCount}"
        holder.binding.layout.tag = items?.get(position)
        holder.binding.layout.setOnClickListener(clickListener)
    }

    class VideoViewHolder(private var v: View):BaseViewHolder<ItemVideoBinding>(v)
}