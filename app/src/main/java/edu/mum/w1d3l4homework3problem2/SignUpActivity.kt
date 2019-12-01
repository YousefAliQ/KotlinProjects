package edu.mum.w1d3l4homework3problem2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        createUserBtn.setOnClickListener{
            val firstname= firstname.text.toString()
            val lastname = lastname.text.toString()
            val username = username.text.toString()
            val password = password.text.toString()

            if (firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || password.isEmpty() ){

                Toast.makeText(this, "please fill all fields.", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this, "User created successfully!", Toast.LENGTH_LONG).show()


                val data = Intent()

                val account = User(firstname, lastname, username, password)
                data.putExtra("user", account)

                setResult(Activity.RESULT_OK, data)
                finish()

            }
        }
    }
}
