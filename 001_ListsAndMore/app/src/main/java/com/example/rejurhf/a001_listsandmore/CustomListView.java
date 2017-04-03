package com.example.rejurhf.a001_listsandmore;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Rejurhf on 03.04.2017.
 */

public class CustomListView extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_list_layout);
    }
}
