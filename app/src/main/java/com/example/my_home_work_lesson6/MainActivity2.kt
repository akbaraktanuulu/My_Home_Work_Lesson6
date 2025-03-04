package com.example.my_home_work_lesson6

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class MainActivity2 : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: ItemAdapter? = null
    private var itemList: MutableList<Item>? = null

    private var recyclerView2: RecyclerView? = null
    private var adapter2: ItemAdapter2? = null
    private var itemList2: MutableList<Item2>? = null

    private var editText: EditText? = null

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editText = findViewById(R.id.search)
        setupFirstRecyclerView()
        setupSecondRecyclerView()
        searchLogic()
    }

    private fun setupFirstRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )

        itemList = ArrayList()
        itemList!!.add(Item("Burgers", "Burgers", R.drawable.ic_burger))
        itemList!!.add(Item("Pizza", "Pizza", R.drawable.ic_pizza))
        itemList!!.add(Item("Chicken", "Chicken", R.drawable.ic_chicken))

        adapter = ItemAdapter(itemList!!, { position: Int ->
            val clickedItem = itemList!!.get(position)
            itemList!!.removeAt(position)
            itemList!!.add(0, clickedItem)
            adapter!!.notifyItemMoved(position, 0)
            adapter!!.notifyDataSetChanged()
        })

        recyclerView!!.setAdapter(adapter)
    }

    private fun setupSecondRecyclerView() {
        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView2!!.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )

        itemList2 = ArrayList()
        itemList2!!.add(Item2("Burgers", "12", R.drawable.ic_salad_burger))
        itemList2!!.add(Item2("Pizza", "15", R.drawable.ic_salad_burger))
        itemList2!!.add(Item2("Chicken", "30", R.drawable.ic_salad_burger))

        adapter2 = ItemAdapter2(itemList2!!, { position: Int ->
            val clickedItem = itemList2!!.get(position)
            itemList2!!.removeAt(position)
            itemList2!!.add(0, clickedItem)

            adapter2!!.notifyItemMoved(position, 0)
            adapter2!!.notifyDataSetChanged()
        })

        recyclerView2!!.setAdapter(adapter2)
    }

    private fun searchLogic() {
        editText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                filterList(s.toString())
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    private fun filterList(query: String) {
        if (query.isEmpty()) {
            adapter!!.updateList(itemList!!)
            return
        }

        val filteredList: MutableList<Item> = ArrayList()
        val remainingList: MutableList<Item> = ArrayList()

        for (item in itemList!!) {
            if (item.Title().toLowerCase().toString().contains(query.lowercase(Locale.getDefault()))) {
                filteredList.add(item)
            } else {
                remainingList.add(item)
            }
        }
        filteredList.addAll(remainingList)
        adapter!!.updateList(filteredList)
    }
}