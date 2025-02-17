package com.example.intentproject

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var ed: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn_1)
        ed = findViewById(R.id.ed_1)

        btn.setOnClickListener {
            val url = ed.text.toString()

            if (url.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent) // Fixed: Use startActivity instead of startService
            } else {
                Toast.makeText(this, "Enter a valid URL", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
