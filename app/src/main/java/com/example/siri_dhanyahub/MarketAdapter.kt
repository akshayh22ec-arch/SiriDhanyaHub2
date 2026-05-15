package com.example.siri_dhanyahub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MarketAdapter(
    private val list: List<MarketPrice>
) : RecyclerView.Adapter<MarketAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val crop: TextView =
            view.findViewById(R.id.cropName)

        val market: TextView =
            view.findViewById(R.id.marketName)

        val price: TextView =
            view.findViewById(R.id.priceText)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_market, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val item = list[position]

        holder.crop.text = item.crop

        holder.market.text =
            "Market: ${item.market}"

        holder.price.text =
            "Price: ₹${item.price}"
    }
}