package com.example.rejurhf.a001_listsandmore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rejurhf on 04.04.2017.
 */

class MyAdapter extends ArrayAdapter<String> {
    public MyAdapter(Context context, String[] list){
        super(context, R.layout.row_layout_2, list);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View kontent = inflater.inflate(R.layout.row_layout_2, parent, false);
        String series = getItem(position);
        TextView text = (TextView) kontent.findViewById(R.id.textView2);
        text.setText(series);
        ImageView image = (ImageView) kontent.findViewById(R.id.dot);
        image.setImageResource(R.mipmap.dot);
        return kontent;
    }
}
