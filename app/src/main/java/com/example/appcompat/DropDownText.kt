package com.example.appcompat

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.layout_general.view.*

class DropDownText : LinearLayout {
    private lateinit var adapters: AdapterMy
    private var listAdapter: ArrayList<ValueListModel> = arrayListOf()
    private var listSearches: ArrayList<SearchElementsModel> = arrayListOf()

    fun listAdapter(list: ArrayList<ValueListModel>){
        listAdapter = list
    }
    fun listSearch(list: ArrayList<SearchElementsModel>){
        listSearches = list
    }

    constructor(context: Context) : super(context) {
        init(context)
    }

    @SuppressLint("CustomViewStyleable")
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
        init(attrs)
        arrayListOf(initLayout(layoutLay), initLayout(used))
    }

    private fun init(context: Context): View {
        //do setup work here
        return inflate(context, R.layout.layout_general, this)
    }

    private fun init(attrs: AttributeSet?){
        val attributesHim = context.obtainStyledAttributes(attrs, R.styleable.MyLayoutHim)
        textHim.text = attributesHim.getText(0)
        attributesHim.recycle()

        val attributesMaven = context.obtainStyledAttributes(attrs, R.styleable.MyLayoutMaven)
        textMaven.hint = attributesMaven.getText(0)
        attributesMaven.recycle()

    }

    private fun initLayout(view: LinearLayout){
        adapters = AdapterMy(object : MyHolder.Listener{
            override fun setOnClickListener(item: SearchElementsModel) {
                titleTxt.text = item.text
                imageProfile.setImageDrawable(item.im)
                descriptionText.text = item.text
                used.isVisible = false
                layoutLay.isVisible = true
                adapters.delete()
            }
        })
        view.setOnClickListener {
            val list: ArrayList<SearchElementsModel> = arrayListOf()
            listAdapter.forEach {
                list.add(SearchElementsModel(it.im, it.text))
            }

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
            adapters.filter(it, listSearches)

            if (textMaven.text.isEmpty()){
                adapters.delete()
            }else{
                recyclerView.adapter = adapters
            }
        }
    }
}