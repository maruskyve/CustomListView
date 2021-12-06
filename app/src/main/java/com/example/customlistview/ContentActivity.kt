package com.example.customlistview

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        supportActionBar?.hide()

        val backBtn = findViewById<ImageButton>(R.id.btn_back)
        val title = intent.getStringExtra("title")
        val thumbnail = intent.getIntExtra("thumbnail", R.drawable.c_logo_100)
        val desc = intent.getStringExtra("desc")

        val contentThumbnail = findViewById<ImageView>(R.id.contentThumbnail)
        val contentTitle = findViewById<TextView>(R.id.contentTitle)
        val contentDesc = findViewById<TextView>(R.id.contentDesc)

        contentThumbnail.setImageResource(thumbnail)
        contentTitle.text = title
        contentDesc.text = desc

        backBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

}