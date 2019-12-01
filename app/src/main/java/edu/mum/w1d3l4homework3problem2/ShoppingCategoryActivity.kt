package edu.mum.w1d3l4homework3problem2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val intent = getIntent()
        val username = intent.getStringExtra("username")

        welomeTV.text = username

        imageView1.setOnClickListener {
            Toast.makeText(this, "Elecetronics Category selected.", Toast.LENGTH_LONG).show()
        }
        imageView2.setOnClickListener{
            Toast.makeText(this, "Clothing Category selected.", Toast.LENGTH_LONG).show()
        }
        imageView3.setOnClickListener{
            Toast.makeText(this, "Beauty Category selected.", Toast.LENGTH_LONG).show()
        }
        imageView4.setOnClickListener{
            Toast.makeText(this, "Food Category selected.", Toast.LENGTH_LONG).show()
        }

    }
}
