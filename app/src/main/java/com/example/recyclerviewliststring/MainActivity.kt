package com.example.recyclerviewliststring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //  get recycler view
        val rv = findViewById<RecyclerView>(R.id.recyclerView1)
        // Give the recycler view with Linear layout manager.
        rv?.layoutManager =  LinearLayoutManager(this)
        // Populate Book data list
        val products = ArrayList<Product>()
        products.add(Product("P1",20.0,"Red", "product1", R.drawable.default1.toString(), "Good printer!" ))
        products.add(Product("P2",21.0,"Green", "product2", R.drawable.index.toString(), "Good One!" ))
        products.add(Product("P3",22.0,"Blue", "product3", R.drawable.index2.toString(), "Good One!" ))
        products.add(Product("P4",23.0,"Yellow", "product4", R.drawable.cbdskincare.toString(), "Good One!" ))
        products.add(Product("P5",24.0,"Black", "product5", R.drawable.xx.toString(), "Good One!" ))

        // Create an adapter and supply the data to be displayed.
        var adapter = CustomAdapter(products)
        // Connect the adapter with the recycler view.
        rv.adapter = adapter

        rv.setOnClickListener { v->
            run {
                products.forEach({
                    if (v.title.toString() == it.title.toString()) {
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("product", it)
                        startActivity(intent)
                    }
                })
            }
        }
    }
}
