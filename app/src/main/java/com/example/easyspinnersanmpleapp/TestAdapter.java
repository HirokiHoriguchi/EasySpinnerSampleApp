package com.example.easyspinnersanmpleapp;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TestAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private int LayoutID;
    private String[] names;
    private int[] imageIDs;

    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }

    TestAdapter(Context context, int itemLayoutId, String[] spinnerItem, String[] spinnerImage){
        layoutInflater = LayoutInflater.from(context);
        LayoutID = itemLayoutId;
        names = spinnerItem;
        imageIDs = new int[spinnerImage.length];
        Resources resources = context.getResources();

        for (int i = 0; i < spinnerImage.length; i++){
            imageIDs[i] = resources.getIdentifier(spinnerImage[i],"drawable", context.getPackageName());
        }
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = layoutInflater.inflate(LayoutID, null);
            viewHolder = new ViewHolder();

            viewHolder.imageView = convertView.findViewById(R.id.image_view2);
            viewHolder.textView = convertView.findViewById(R.id.text_view2);
            convertView.setTag(viewHolder);

        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageView.setImageResource(imageIDs[position]);
        viewHolder.textView.setText(names[position]);


        return convertView;
    }



    public int getCount(){
        return names.length;
    }

    public Object getItem(int positoin){
        return positoin;
    }

    public long getItemId(int positoin){
        return positoin;
    }



}
