package com.example.rejurhf.a001_listsandmore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Rejurhf on 04.04.2017.
 */

public class ComplexListView extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_listview_layout);

        String[] favoriteSeries = {"Lost", "Vikings", "Breaking Bad", "Game of Thrones", "Ranczo",
                "Makłowicz w podróży", "Janosik", "Czterej pancerni i pies"};
        ListAdapter newAdapter = new MyAdapter(this, favoriteSeries);
        ListView list = (ListView) findViewById(R.id.custom_list);
        list.setAdapter(newAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = "You chose " + String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(ComplexListView.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void backButton(View view) {
        Intent goingBack = new Intent();
        setResult(RESULT_OK, goingBack);
        finish();
    }
}
