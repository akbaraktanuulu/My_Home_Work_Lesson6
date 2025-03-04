package com.example.my_home_work_lesson6

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.my_home_work_lesson6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        this.enableEdgeToEdge()
        setContentView(binding!!.root)
        ViewCompat.setOnApplyWindowInsetsListener(
            binding!!.main
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding!!.btnOpen.setOnClickListener { v: View? ->
            if (check()) {
                Toast.makeText(
                    this@MainActivity,
                    "Вы успешно авторизовались!",
                    Toast.LENGTH_SHORT
                ).show()
                val intent =
                    Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Вы вели неправильный логин или пароль!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun check(): Boolean {
        val tex1 = binding!!.email.text.toString()
        val tex2 = binding!!.password.text.toString()
        return tex1 == "admin" && tex2 == "admin"
    }
}