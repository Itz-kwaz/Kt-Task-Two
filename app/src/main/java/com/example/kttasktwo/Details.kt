package com.example.kttasktwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.simple_layout.*
import org.w3c.dom.Text

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val price:TextView = findViewById(R.id.price)
        val itemImage:ImageView = findViewById(R.id.image)
        val name:TextView = findViewById(R.id.item_name)
        val details:TextView = findViewById(R.id.details)

        val intent = intent

        price.text = intent.getStringExtra("price")


        itemImage.setImageResource(intent.getIntExtra("Image",0))
        name.setText(intent.getIntExtra("name",0))
        details.setText(intent.getIntExtra("details",0))


    }
}
