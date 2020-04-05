package com.losingtimeapps.testionix.util

import android.content.Context
import android.text.Html
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.losingtimeapps.testionix.R
import info.androidhive.fontawesome.FontDrawable
import kotlinx.android.synthetic.main.menu_custom_view.view.*


class CustomMenuView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {


    init {
        val view = LayoutInflater.from(context).inflate(R.layout.menu_custom_view, this, false)

        addView(view)

    }

    fun setData(title: String, icon: Int) {
        titleTv.text = title
        val drawable = FontDrawable(this.context, icon, true, false)
        drawable.setTextColor(ContextCompat.getColor(this.context, R.color.black_60))
        iconIv.setImageDrawable(drawable);
    }


}
