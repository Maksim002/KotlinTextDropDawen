package com.example.appcompat

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_riciler.view.*
import kotlinx.android.synthetic.main.item_riciler.view.image_profile
import kotlinx.android.synthetic.main.item_riciler.view.titoloTv
import kotlinx.android.synthetic.main.item_riciler.view.titoloTvThim

class MyHolder(iteView: View, var listener: Listener): RecyclerView.ViewHolder(iteView) {

    fun bond(item: ModelSSSS, holder: MyHolder) = with(holder.itemView) {
        titoloTv.text = item.text
        image_profile.setImageDrawable(item.im)
        titoloTvThim.text = item.text
        nameLay.setOnClickListener {
            listener.setOnClickListener(item)
        }
    }

    interface Listener{
        fun setOnClickListener(item: ModelSSSS)
    }
}

