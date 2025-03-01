package com.example.my_home_work_lesson6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Item> itemList;

    private RecyclerView recyclerView2;
    private ItemAdapter2 adapter2;
    private List<Item2> itemList2;

    private EditText editText;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.search);
        setupFirstRecyclerView();
        setupSecondRecyclerView();
        searchLogic();
    }

    private void setupFirstRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        itemList = new ArrayList<>();
        itemList.add(new Item("Burgers", "Burgers", R.drawable.ic_burger));
        itemList.add(new Item("Pizza", "Pizza", R.drawable.ic_pizza));
        itemList.add(new Item("Chicken", "Chicken", R.drawable.ic_chicken));

        adapter = new ItemAdapter(itemList, position -> {
            Item clickedItem = itemList.get(position);
            itemList.remove(position);
            itemList.add(0, clickedItem);
            adapter.notifyItemMoved(position, 0);
            adapter.notifyDataSetChanged();
        });

        recyclerView.setAdapter(adapter);
    }

    private void setupSecondRecyclerView() {
        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        itemList2 = new ArrayList<>();
        itemList2.add(new Item2("Burgers", "12", R.drawable.ic_salad_burger));
        itemList2.add(new Item2("Pizza", "15", R.drawable.ic_salad_burger));
        itemList2.add(new Item2("Chicken", "30", R.drawable.ic_salad_burger));

        adapter2 = new ItemAdapter2(itemList2, position -> {
            Item2 clickedItem = itemList2.get(position);
            itemList2.remove(position);
            itemList2.add(0, clickedItem);

            adapter2.notifyItemMoved(position, 0);
            adapter2.notifyDataSetChanged();
        });

        recyclerView2.setAdapter(adapter2);
    }

    private void searchLogic() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterList(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filterList(String query) {
        if (query.isEmpty()) {
            adapter.updateList(itemList);
            return;
        }

        List<Item> filteredList = new ArrayList<>();
        List<Item> remainingList = new ArrayList<>();

        for (Item item : itemList) {
            if (item.getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            } else {
                remainingList.add(item);
            }
        }
        filteredList.addAll(remainingList);
        adapter.updateList(filteredList);
    }
}
