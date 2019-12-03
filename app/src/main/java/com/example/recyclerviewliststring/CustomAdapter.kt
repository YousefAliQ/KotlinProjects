package com.example.recyclerviewliststring
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
import java.lang.Integer.parseInt


class CustomAdapter(val productlist: ArrayList<Product>): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    /**
     * Sets the contents of an item at a given position in the RecyclerView.
     * Called by RecyclerView to display the data at a specified position.
     *
     * @param holder The view holder for that position in the RecyclerView.
     * @param position The position of the item in the RecycerView.
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder?.pColor?.text = "Color : " + productlist[position].color
        holder?.pTitle.text = productlist[position].title
        holder?.pImage.setImageResource(parseInt(productlist[position].itemid))
        holder?.pPrice.text = "Price : " + productlist[position].price?.toDouble().toString()

        holder.itemView.setOnClickListener {
            productlist.forEach{ p->
                run {
                    if (p.title.toString().equals(it.title.text.toString())) {

                        val context: Context = it.getContext()
                        val intent = Intent(context, DetailsActivity::class.java)
                        intent.putExtra("product", p)
                        context.startActivity(intent)

                    }
                }
            }
        }

    }

    /**
     * Inflates an item view and returns a new view holder that contains it.
     * Called when the RecyclerView needs a new view holder to represent an item.
     *
     * @param parent The view group that holds the item views.
     * @param viewType Used to distinguish views, if more than one type of item view is used.
     * @return a view holder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(v);
    }
    /**
     * Returns the size of the container that holds the data.
     * @return Size of the list of data.
     */
    override fun getItemCount(): Int {
        return productlist.size
    }

    /*RecyclerView.Adapter accepts the generic type of your Adapter inner class ViewHolder type.
  In this example Adapter class name is CustomAdapter and the MyViewHolder  is the inner class */
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val pImage = itemView.findViewById<ImageView>(R.id.image)
        val pPrice = itemView.findViewById<TextView>(R.id.price)
        val pTitle = itemView.findViewById<TextView>(R.id.title)
        val pColor = itemView.findViewById<TextView>(R.id.color)

    }
}