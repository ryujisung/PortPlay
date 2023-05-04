package com.example.portplay.view.header

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import com.example.portplay.R
import com.example.portplay.databinding.ViewHeaderMainBinding

class MainHeader : LinearLayout {
    lateinit var view: ViewHeaderMainBinding

    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        initView(context)
    }



    private fun initView(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = ViewHeaderMainBinding.inflate(inflater)

        val lp = LayoutParams(MATCH_PARENT, MATCH_PARENT)
        view.root.layoutParams = lp


        addView(view.root)
    }
}