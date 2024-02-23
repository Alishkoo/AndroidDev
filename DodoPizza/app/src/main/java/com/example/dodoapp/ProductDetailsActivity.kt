package com.example.dodoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class ProductDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val productItem = intent.getParcelableExtra<ItemsViewModel>("productItem")

        val TextName: TextView = findViewById(R.id.textName)
        val TextDesc: TextView = findViewById(R.id.textDesc)
        val Button: Button = findViewById(R.id.button2)
        val image: ImageView = findViewById(R.id.imageView)
        val buttonGoBack: ImageButton = findViewById(R.id.buttonGoBack)


        TextName.text = productItem?.Nametext
        TextDesc.text = productItem?.DescText
        Button.text = productItem?.ButtonText
        image.setImageResource(productItem?.image!!)

        buttonGoBack.setOnClickListener {
            // Создаем Intent для возврата в MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Добавляем флаг, чтобы очистить все активности на вершине стека
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            // Запускаем MainActivity
            startActivity(intent)
            // Закрываем текущую активность
            finish()
        }
    }
    }
