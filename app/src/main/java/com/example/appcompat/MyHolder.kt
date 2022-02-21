package com.example.appcompat

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_riciler.view.*

class MyHolder(iteView: View, var listener: Listener): RecyclerView.ViewHolder(iteView) {

    fun bond(item: SearchElementsModel, holder: MyHolder) = with(holder.itemView) {
        titleTxt.text = item.text
        imageProfile.setImageDrawable(item.im)
        descriptionTxt.text = item.text
        nameLay.setOnClickListener {
            listener.setOnClickListener(item)
        }
    }

    interface Listener{
        fun setOnClickListener(item: SearchElementsModel)
    }
}

