package com.example.customlistview

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class CustomList (private val context: Activity,
                  private val thumbnail: Array<Int>,
                  private val number : Array<Int>,
                  private val title : Array<String>,
                  private val desc : Array<String>)
    :ArrayAdapter<String>(context, R.layout.activity_custom_list, desc) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val theView = inflater.inflate(R.layout.activity_custom_list, null, true)

        val itemNumber = theView.findViewById<TextView>(R.id.item_number)
        val itemTitle = theView.findViewById<TextView>(R.id.item_title)
        val itemDescription = theView.findViewById<TextView>(R.id.item_description)
        val itemThumbnail = theView.findViewById<ImageView>(R.id.thumbnail)

        itemNumber.text = number[position].toString()
        itemTitle.text = title[position]
        itemDescription.text = desc[position]
        itemThumbnail.setImageResource(thumbnail[position])

        return theView
    }
}