package com.example.rejurhf.a002_fragments;

import android.content.res.Configuration;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int screenOrientation = getResources().getConfiguration().orientation;
        if(screenOrientation == Configuration.ORIENTATION_PORTRAIT)
            hideSidePanel();
    }

    private void hideSidePanel() {
        View sidePanel = findViewById(R.id.side_panel);
        if(sidePanel.getVisibility() == View.VISIBLE)
            sidePanel.setVisibility(View.GONE);
    }
}
