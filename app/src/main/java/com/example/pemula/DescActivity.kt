package com.example.pemula

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class DescActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desc)
        val item = intent.getParcelableExtra<Item>("data")

        val name    = findViewById<TextView>(R.id.item_detail_name)
        val logo    = findViewById<ImageView>(R.id.item_detail_logo)
        val basecamp= findViewById<TextView>(R.id.item_detail_basecamp)
        val coach   = findViewById<TextView>(R.id.item_detail_coach)
        val captain = findViewById<TextView>(R.id.item_detail_captain)
        val sponsor = findViewById<TextView>(R.id.item_detail_sponsor)
        val description = findViewById<TextView>(R.id.item_detail_description)

        name.text       = item.name
        Glide.with(this).load(item.logo).into(logo)
        basecamp.text   = item.basecamp
        coach.text      = item.coach
        captain.text    = item.captain
        sponsor.text    = item.sponsor
        description.text = item.desc
    }
}
