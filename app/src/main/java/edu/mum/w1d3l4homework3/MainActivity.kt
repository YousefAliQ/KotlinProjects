package edu.mum.w1d3l4homework3

import android.app.ActionBar
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Space
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBtn.setOnClickListener({

            var version = androidVersion.text.toString()
            var code = androidCode.text.toString()

            if (version.length > 0 && code.length > 0)
                 addNewRow(version,  code)
            // else toast

        })
    }

    fun addNewRow( version:String,  code:String){


        // Create a new table row.
        val tableRow = TableRow(getApplicationContext())
        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT)
        tableRow.setLayoutParams(layoutParams)
        tableRow.setBackgroundColor(Color.BLACK)
        tableRow.setPadding(3,3,3,3)


        val verTextView = TextView(this)
        verTextView.textSize = 20f
        verTextView.text = version

        verTextView.setBackgroundColor(Color.RED)

        val codeTextView = TextView(this)
        codeTextView.textSize = 20f
        codeTextView.text = code
        codeTextView.setBackgroundColor(Color.RED)

        // add values into row by calling addView()
        tableRow.addView(verTextView,0)
        tableRow.addView(codeTextView,1)
        // Finally add the created row row into layout

        val space = Space(this)
        space.minimumHeight = 5
        androidTable.addView(space)

        androidTable.addView(tableRow) // id from Layout_file




    }
}
