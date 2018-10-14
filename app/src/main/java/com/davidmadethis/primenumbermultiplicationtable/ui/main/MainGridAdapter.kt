package com.davidmadethis.primenumbermultiplicationtable.ui.main

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import android.graphics.Color.parseColor
import androidx.core.content.ContextCompat.getSystemService
import android.view.LayoutInflater
import com.davidmadethis.primenumbermultiplicationtable.R
import com.davidmadethis.primenumbermultiplicationtable.data.Constants

class MainGridAdapter(val numbers:List<Int>, val context: Context):BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var textView:TextView?  = null

        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            textView = inflater.inflate(R.layout.grid_item, parent, false) as TextView

//            textView.setPadding(8, 8, 8, 8);
        }
        else{
            textView = convertView as TextView
        }


        val number = numbers[position]
        if(number!=1)
        textView.setText(number.toString())

        if ((position/ Constants.GRID_COUNT) %2 == 0)
            textView.setBackgroundColor(Color.LTGRAY);
        else
            textView.setBackgroundColor(Color.WHITE);


        return textView

    }

    override fun getItem(position: Int): Any = null!!

    override fun getItemId(position: Int): Long =0

    override fun getCount(): Int = numbers.size


}