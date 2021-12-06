package com.example.customlistview

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import java.util.*

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // buat data source
        val number = arrayOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12)
        val title = arrayOf<String>("C", "C++", "Java", "Kotlin", "Ruby","Phyton", "Javascript", "Net", "Perl", "PHP", "Ajax", "Golang")
        val desc = arrayOf<String>(
            "bahasa C adalah................",
            "bahasa C++ adalah................",
            "bahasa Java adalah................",
            "bahasa Kotlin adalah................",
            "bahasa Ruby adalah................",
            "bahasa Phyton adalah................",
            "bahasa javascript adalah................",
            "bahasa Net adalah................",
            "bahasa Perl adalah................",
            "bahasa PHP adalah................",
            "bahasa Ajax adalah................",
            "bahasa Golang adalah................"
        )
        val thumbnailPaths = arrayOf<Int>(
            R.drawable.c_logo_100, R.drawable.cpp_logo_100, R.drawable.java_logo_100,
            R.drawable.kotlin_logo_100, R.drawable.ruby_logo_100, R.drawable.python_logo_100,
            R.drawable.js_logo_100, R.drawable.net_logo_100, R.drawable.perl_logo_100,
            R.drawable.php_logo_100, R.drawable.ajax_logo_398, R.drawable.go_logo_100)
        val contentDescs = arrayOf<Int>(
            R.string.c_contentDesc, R.string.cpp_contentDesc, R.string.java_contentDesc,
            R.string.kotlin_contentDesc, R.string.ruby_contentDesc, R.string.python_contentDesc,
            R.string.js_contentDesc, R.string.net_contentDesc, R.string.perl_contentDesc,
            R.string.php_contentDesc, R.string.ajax_contentDesc, R.string.go_contentDesc
        )
        val totalUsers = arrayOf<Int>(
            803461,
            905375,
            4153799,
            670855,
            1211608,
            1849355,
            3967400,
            7534654,
            234567,
            1297950,
            431239,
            323442)

        val myListAdapter = CustomList(this, thumbnailPaths, number, title, desc, totalUsers)
        val listView = findViewById<View>(R.id.list_view) as ListView
        listView.adapter = myListAdapter

        // onitemclick
        listView.setOnItemClickListener() {
                adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
//            Toast.makeText(this, "Anda memilih : $itemAtPos atau $itemIdAtPos, POS[$position]", Toast.LENGTH_LONG).show()

            val contentIntent = Intent(this, ContentActivity::class.java)
            contentIntent.putExtra("title", title[position])
            contentIntent.putExtra("thumbnail", thumbnailPaths[position])
            contentIntent.putExtra("desc", getString(contentDescs[position]))
            startActivity(contentIntent)
        }
    }
}