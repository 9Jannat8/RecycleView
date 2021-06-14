package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.afghanistan, R.drawable.bahrain, R.drawable.bangladesh, R.drawable.bhutan, R.drawable.china, R.drawable.india,
    R.drawable.japan, R.drawable.nepal, R.drawable.pakistan, R.drawable.srilanka};

    MyAdapter myAdapter;
    String[] title, desc;


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerId);

        title = getResources().getStringArray(R.array.country);
        desc = getResources().getStringArray(R.array.description);

        myAdapter = new MyAdapter(this, title, desc, images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.setOnItemClickListener(new MyAdapter.Clicklistener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(getApplicationContext(), "onitem click " + position, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Toast.makeText(getApplicationContext(), "onitemlong click " + position, Toast.LENGTH_LONG).show();
            }
        });
    }
}