package com.example.rejurhf.a001_listsandmore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Rejurhf on 22.03.2017.
 */

public class GetName extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.set_name_activity);
        Intent activityThatCalled = getIntent();
        String passedInformation = activityThatCalled.getExtras().getString("callingActivity");
        TextView callingInformation = (TextView) findViewById(R.id.about_call_text_view);
        callingInformation.append(" " + passedInformation);
    }

    public void sendButton(View view) {
        EditText userNameEditText = (EditText) findViewById(R.id.name_edit_text);
        String userName = String.valueOf(userNameEditText.getText());
        Intent goingBack = new Intent();
        goingBack.putExtra("UserName", userName);
        setResult(RESULT_OK, goingBack);
        finish();
    }

    public void backButton(View view) {
        finish();
    }
}
