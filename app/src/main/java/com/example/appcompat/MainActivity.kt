package com.example.appcompat

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

import android.widget.SimpleAdapter
import android.R.attr.thumbnail
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.layout_general.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapters: AdapterMy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrayListOf(sp(layoutLay), sp(used))
    }

    private fun sp(view: LinearLayout){
        adapters = AdapterMy(object : MyHolder.Listener{
            override fun setOnClickListener(item: ModelSSSS) {
                titoloTv.text = item.text
                image_profile.setImageDrawable(item.im)
                titoloTvThim.text = item.text
                used.isVisible = false
                layoutLay.isVisible = true
                adapters.delete()
            }
        })
        view.setOnClickListener {
            val list: ArrayList<ModelSSSS> = arrayListOf()
            list.add(ModelSSSS(resources.getDrawable(R.drawable.fff), "zzzzzzzz"))
            list.add(ModelSSSS(resources.getDrawable(R.drawable.ttt), "eeeeee"))
            list.add(ModelSSSS(resources.getDrawable(R.drawable.fff), "wsefrekkkkfe"))
            list.add(ModelSSSS(resources.getDrawable(R.drawable.ttt), "oooo"))
            list.add(ModelSSSS(resources.getDrawable(R.drawable.eee), "lllll"))

            clearBtn.setOnClickListener {
                used.isVisible = true
                layoutLay.isVisible = false
                textMaven.setText("")
                adapters.delete()
            }

            clearTxtBtn.setOnClickListener {
                textMaven.setText("")
            }
            adapters.update(list)
            recyclerView.adapter = adapters
        }

        textMaven.addTextChangedListener {
            val list: ArrayList<ModelSSSS> = arrayListOf()
            list.add(ModelSSSS(resources.getDrawable(R.drawable.fff), "zzzzzzzz"))
            list.add(ModelSSSS(resources.getDrawable(R.drawable.ttt), "eeeeee"))
            list.add(ModelSSSS(resources.getDrawable(R.drawable.fff), "wsefrekkkkfe"))
            list.add(ModelSSSS(resources.getDrawable(R.drawable.ttt), "oooo"))
            list.add(ModelSSSS(resources.getDrawable(R.drawable.eee), "lllll"))

            adapters.filter(it, list)

            if (textMaven.text.isEmpty()){
                adapters.delete()
            }else{
                recyclerView.adapter = adapters
            }
        }
    }
}