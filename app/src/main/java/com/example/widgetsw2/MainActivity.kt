package com.example.widgetsw2

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.image)
        val editText = findViewById<EditText>(R.id.edit_text)
        val setImage = {

            val picasso= Picasso.get().load(editText.text.toString())
            picasso.into(image, object : com.squareup.picasso.Callback{
                override fun onSuccess() {}
                override fun onError(e: Exception?) {
                    if (e!= null) Toast.makeText(this@MainActivity, "Image loading failed", Toast.LENGTH_SHORT).show()
                }
            })
        }

        editText.setOnEditorActionListener { v, i, event ->
            if (i == EditorInfo.IME_ACTION_DONE || (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                // Handle the Enter key press here
                setImage()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }
}