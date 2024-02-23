package com.example.dodoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dodoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CustomAdapter.ButtonClickListener {

    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        // getting the recyclerview by its id
        val recyclerview = bindingClass.recyclerview // попробовал биндинг работает или нет
        // и так же если будут спрашивать использовал ли биндинг то просто заменить все переменные ;)

        // getting edittext-view by its id
        val searchEditText: EditText = findViewById(R.id.searchEditText)
        val searchButton: Button = findViewById(R.id.searchButton)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()


        //Adding data to pizza
        data.add(ItemsViewModel(R.drawable._1eebaa6544b613697512c486cf81fc0_292x292,
            "Баварская",
            "Острые колбаски чоризо, маринованные огурчики, красный лук, томаты, горчичный соус, моцарелла, фирменный томатный соус",
            "от 2 700тг."))
        data.add(ItemsViewModel(R.drawable._1eeca3858c79a01b7a644c5a5d81524_292x292,
            "Пепперони-сердце",
            "Уникальная пицца в форме сердца. Томатный соус, пепперони, моцарелла",
            "от 3 500тг."))
        data.add(ItemsViewModel(R.drawable._1ee92ccdb73713db65546f163b5391b_292x292,
            "Наруто Пицца",
            "Куриные кусочки, соус терияки, ананасы, моцарелла, фирменный соус альфредо",
            "от 3 900тг."))
        data.add(ItemsViewModel(R.drawable._1ee901d1c0a73f39a81e89f3c1f0c2f_292x292,
            "Вау! Кебаб",
            "Мясо говядины, соус ранч, сыр моцарелла, сладкий перец, томаты, красный лук и фирменный томатный соус",
            "от 2 900тг."))
        data.add(ItemsViewModel(R.drawable._1eebaa6544b613697512c486cf81fc0_292x292,
            "Пепперони с грибами",
            "Пикантная пепперони, моцарелла, шампиньоны, соус альфредо",
            "от 2 000тг."))

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data, this)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        // Adding a listener to searchbutton
        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            adapter.filter(query)
        }
    }

    override fun onButtonClick(item: ItemsViewModel) {
        // Запустите новую активность, передавая данные о продукте
        val intent = Intent(this, ProductDetailsActivity::class.java)
        intent.putExtra("productItem", item)
        startActivity(intent)
    }
}