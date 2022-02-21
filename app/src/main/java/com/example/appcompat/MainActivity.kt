package com.example.appcompat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_general.*

class MainActivity : AppCompatActivity(){

    private lateinit var adapters: AdapterMy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list1: ArrayList<ValueListModel> = arrayListOf()
        list1.add(ValueListModel(resources.getDrawable(R.drawable.fff), "zzzzzzzz"))
        list1.add(ValueListModel(resources.getDrawable(R.drawable.ttt), "eeeeee"))
        list1.add(ValueListModel(resources.getDrawable(R.drawable.fff), "wsefrekkkkfe"))
        list1.add(ValueListModel(resources.getDrawable(R.drawable.ttt), "oooo"))
        list1.add(ValueListModel(resources.getDrawable(R.drawable.eee), "lllll"))

        val list2: ArrayList<SearchElementsModel> = arrayListOf()
        list2.add(SearchElementsModel(resources.getDrawable(R.drawable.fff), "zzzzzzzz"))
        list2.add(SearchElementsModel(resources.getDrawable(R.drawable.ttt), "eeeeee"))
        list2.add(SearchElementsModel(resources.getDrawable(R.drawable.fff), "wsefrekkkkfe"))
        list2.add(SearchElementsModel(resources.getDrawable(R.drawable.ttt), "oooo"))
        list2.add(SearchElementsModel(resources.getDrawable(R.drawable.eee), "lllll"))

        dropTxt.listAdapter(list1)
        dropTxt.listSearch(list2)
    }
}