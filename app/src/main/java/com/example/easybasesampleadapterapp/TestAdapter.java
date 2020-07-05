package com.example.easybasesampleadapterapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TestAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private int layoutID;
    private String[] namelist;
    private String[] emaillist;
    private Bitmap[] photolist;

    @Override
    public int getCount() {
        return namelist.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        TextView textView;
        TextView email;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;



//        ここでlist_itemのレイアウトファイル内にあるそれぞれの要素をfindしてそのR番号を取得しておく。
//        ここで取得したID番号は、その都度呼び出すのではなく、このクラス内のViewHolderに記録しておくことで、動作が早くなるのか知らないけどメリットがあるらしい。
        if (convertView == null){
            convertView = layoutInflater.inflate(layoutID, null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.img_item);
            holder.textView = convertView.findViewById(R.id.text_view);
            holder.email = convertView.findViewById(R.id.text_email);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageBitmap(photolist[position]);

        String str = "Stag ID.170900" + String.valueOf(position + 1)
                + "\n\nEmail:" + emaillist[position]
                + "\nTel: 020-8931-9993 #340" + String.valueOf(position +1);

        holder.email.setText(str);
        holder.textView.setText(namelist[position]);
        return convertView;
    }



    TestAdapter(Context context, int itemLayoutID, String[] names, int[] photos, String[] emails){
        layoutInflater = LayoutInflater.from(context);

        layoutID = itemLayoutID;

        namelist = names;

        emaillist = emails;

        photolist = new Bitmap[photos.length];

        for (int i = 0; i < photos.length; i++){
            photolist[i] = BitmapFactory.decodeResource(context.getResources(), photos[i]);
        }

    }




}
