package com.example.easybasesampleadapterapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private BaseAdapter adapter;

    private List<String> itemNames;
    private List<Integer> itemImages;

    private int tappeedPositoin = 0;

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

        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = itemNames.get(position);

        setPosition(position);

        alearChech(item);
    }

    private void setPosition(int position) {
        tappeedPositoin = position;
    }

    private int getPositoin() {
        return tappeedPositoin;
    }

    private void alearChech(String item) {
        String[] alert_menu = {"上に移動", "下に移動", "削除", "cancel"};

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle(item);

        alert.setItems(alert_menu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        moveAbove();
                        break;
                    case 1:
                        moveBelow();
                        break;
                    case 2:
                        deletecheck();
                    default:
                        Log.d("debug", "cancel");
                        break;
                }
            }
        });

        alert.show();
    }




    private void deletecheck(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Delete");

        alertDialogBuilder.setMessage("Do you really delete this?");

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteItem();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        alertDialogBuilder.setCancelable(true);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void deleteItem(){
        int positoin = getPositoin();

        itemNames.remove(positoin);
        itemImages.remove(positoin);

        adapter.notifyDataSetChanged();
    }

    private void moveAbove(){
        int positoin = getPositoin();
        if (positoin > 0){
            String str = itemNames.get(positoin - 1);
            itemNames.set(positoin -1, itemNames.get(positoin));
            itemNames.set(positoin, str);

            int temp = itemImages.get(positoin - 1);
            itemImages.set(positoin -1 ,itemImages.get(positoin));
            itemImages.set(positoin, temp);
            adapter.notifyDataSetChanged();
        }else{
            Log.d("debug", "Error Occured.");
        }
    }


    private void moveBelow(){
        int positoin = getPositoin();

        if (positoin < itemNames.size() - 1){
            String str = itemNames.get(positoin + 1);
            itemNames.set(positoin + 1, itemNames.get(positoin));
            itemNames.set(positoin, str);

            int temp = itemImages.get(positoin + 1);
            itemImages.set(positoin + 1, itemImages.get(positoin));
            itemImages.set(positoin, temp);
            adapter.notifyDataSetChanged();
        }
        else{
            Log.d("debug", "Error Occured!");
        }
    }



}
