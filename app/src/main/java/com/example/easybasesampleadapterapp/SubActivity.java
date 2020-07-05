package com.example.easybasesampleadapterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubActivity extends AppCompatActivity {

    private BaseAdapter adapter;

    private List<String> itemNames;
    private List<Integer> itemImages;

    private int toppeedPositoin = 0;

    private static final String[] scenes = {
            "Ventnor",
            "Wroxall",
            "Whitewell",
            "Ryde",
            "StLawrence",
            "Lake",
            "Sandown",
            "Shanklin"
    };

    private static final Integer[] photos = {
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        itemNames = new ArrayList<>(Arrays.asList(scenes));
        itemImages = new ArrayList<>(Arrays.asList(photos));

        ListView listView = findViewById(R.id.list_view2);

        adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.list, itemNames, itemImages);

        listView.setAdapter(adapter);
    }



}
