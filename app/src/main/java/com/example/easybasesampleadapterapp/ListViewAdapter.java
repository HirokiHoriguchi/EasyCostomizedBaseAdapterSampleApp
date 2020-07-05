package com.example.easybasesampleadapterapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    private LayoutInflater inflater;
    private int itemLayoutID;
    private List<String> titles;
    private List<Integer> ids;

    ListViewAdapter(Context context, int itemLayoutID, List<String> itemNames, List<Integer> itemImages){
        super();
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemLayoutID = itemLayoutID;
        this.titles = itemNames;
        this.ids = itemImages;
    }





    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
//            ここは、activity_subにlist.xmlをinflateしてconvertviewにする処理を書いている。
            convertView = inflater.inflate(itemLayoutID, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageview);
            holder.textView = convertView.findViewById(R.id.textview);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

//        holderのimageView,textviewにセットする。この部分のget(positoin)の役割がよくわからない。。。。。
        holder.imageView.setImageResource(ids.get(position));
        holder.textView.setText(titles.get(position));


        return convertView;



    }
}
