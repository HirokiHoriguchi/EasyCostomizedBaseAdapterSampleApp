package com.example.easybasesampleadapterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private static final String[] names = {
            "image",
            "image1",
            "image2",
            "image3",
            "image4",
            "image5",
            "image6",
            "image7",
            "image8",
            "image9"
    };

    private static final int[] photos = {
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
    };


    Button button;

//    Adapterをカスタムして使用する時に、BaseAdapterを継承して、カスタムリストを作成し、それをlistviewにセットする方法。
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] emails = new String[names.length];
        for (int i=0; i < names.length; i++){
            emails[i] = String.format(Locale.US, "%s@gmail.com", names[i]);
        }

        ListView listView = findViewById(R.id.list_view);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });

        BaseAdapter baseAdapter = new TestAdapter(this.getApplicationContext(), R.layout.list_items, names, photos, emails);

        listView.setAdapter(baseAdapter);
    }
}
