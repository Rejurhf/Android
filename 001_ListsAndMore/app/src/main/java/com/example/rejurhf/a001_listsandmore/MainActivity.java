package com.example.rejurhf.a001_listsandmore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] optionsList = {"Pass Your name", "Custom ListView",
                "Advance ListView", "Conversion"};
        final ListAdapter basicAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, optionsList);
        ListView optionsListView = (ListView) findViewById(R.id.options_list_view);
        optionsListView.setAdapter(basicAdapter);
        optionsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String chosenOption = String.valueOf(parent.getItemAtPosition(position));
                String text = "You chose " + chosenOption;
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                if(chosenOption.equals("Pass Your name")){
                    Intent getNameScreenIntent = new Intent(MainActivity.this, GetName.class);
                    final int resoult = 1;
                    getNameScreenIntent.putExtra("callingActivity", "MainActivity");
                    startActivityForResult(getNameScreenIntent, resoult);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_dialog) {
            DialogFragment newDialog = new DialogWindow();
            newDialog.show(getSupportFragmentManager(), "myDialog");
            return true;
        }else if(id == R.id.action_toast){
            String message = "Hello ";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            return true;
        }else if (id == R.id.action_exit){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView userNameTextView = (TextView) findViewById(R.id.hello_text_view);
        String userName = data.getStringExtra("UserName");
        userNameTextView.append(" " + userName);
    }
}
