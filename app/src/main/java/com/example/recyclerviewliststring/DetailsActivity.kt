package com.example.recyclerviewliststring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*
import java.lang.Integer.parseInt

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val product = intent.getSerializableExtra("product") as? Product

        imageView.setImageResource(parseInt(product?.itemid))
        pTitle.text = product?.title
        color.text = "Color : " + product?.color
        name.text = product?.image
        desc.text = "Description : \n " + product?.desc



    }
}
