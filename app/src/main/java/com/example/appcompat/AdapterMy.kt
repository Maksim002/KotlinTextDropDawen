package com.example.appcompat

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterMy(var listener: MyHolder.Listener, var item: ArrayList<ModelSSSS> = arrayListOf()): RecyclerView.Adapter<MyHolder>() {

    fun update(list: ArrayList<ModelSSSS> = arrayListOf()){
        item = list
        notifyDataSetChanged()
    }

    fun delete(){
        item.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_riciler, parent, false), listener)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
       holder.bond(item[holder.adapterPosition], holder)
    }

    fun filter(sequence: CharSequence? = null, list: ArrayList<ModelSSSS>? = null): ArrayList<ModelSSSS> {
        val temp = ArrayList<ModelSSSS>()
        for (s in list!!) {
            if (s.text.toLowerCase().contains(sequence!!)) {
                temp.add(s)
            }
        }
        update(temp)
        return temp
    }
}