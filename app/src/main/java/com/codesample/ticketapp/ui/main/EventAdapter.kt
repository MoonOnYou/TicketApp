package com.codesample.ticketapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codesample.ticketapp.R
import com.codesample.ticketapp.base.BaseViewHolder
import com.codesample.ticketapp.databinding.ItemEventBinding
import com.codesample.ticketapp.extension.setImageUrl
import com.codesample.ticketapp.model.Event

class EventAdapter(
    var items : ArrayList<Event>?
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var clickListener : View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EventViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is EventViewHolder) itemView(holder, position)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    private fun itemView(holder: EventViewHolder, position: Int) {
        holder.binding.imageView.setImageUrl(items?.get(position)?.thumbnailImageUrl)
        holder.binding.textViewDisplayName.text = items?.get(position)?.displayName
        holder.binding.textViewViewName.text = items?.get(position)?.name
        holder.binding.textViewViewComment.text = items?.get(position)?.comment
        holder.binding.layout.tag = items?.get(position)
        holder.binding.layout.setOnClickListener(clickListener)
    }

    class EventViewHolder(private var v: View): BaseViewHolder<ItemEventBinding>(v)
}