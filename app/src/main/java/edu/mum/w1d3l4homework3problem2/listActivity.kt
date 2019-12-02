package edu.mum.w1d3l4homework3problem2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_list.*

class listActivity : AppCompatActivity() {

    var clothes = arrayOf("belt","boots","cap","coat","dress","gloves","hat","jacket","jeans","pajamas","pants","raincoat","shirt","shoes","skirt","slacks","slippers","socks","stockings","suit","sweater","sweatshirt","t-shirt","tie","trousers","underclothes","underpants","undershirt")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, clothes)
        list.adapter = adapter
        list.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

                val item = parent.getItemAtPosition(position).toString();
                Toast.makeText(this, "$item selected.", Toast.LENGTH_LONG).show()

            }
    }
}
