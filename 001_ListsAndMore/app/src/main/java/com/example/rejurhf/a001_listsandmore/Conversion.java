package com.example.rejurhf.a001_listsandmore;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Rejurhf on 25.04.2017.
 */

public class Conversion extends Activity {
    private Spinner unitTypeSpinner;
    private EditText inputEditText;
    TextView metresTextView, mileTextView, inchTextView,
            feetTextView, yardTextView, stajaTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_app_layout);

        addItemToUnitTypeSpinner();
        addListenerToUnitTypeSpinner();
        inputEditText = (EditText) findViewById(R.id.input_edit_text);
        initializeTextView();
    }

    public void initializeTextView(){
        metresTextView = (TextView) findViewById(R.id.metres_text_view);
        mileTextView = (TextView) findViewById(R.id.mile_text_view);
        inchTextView = (TextView) findViewById(R.id.inch_text_view);
        feetTextView = (TextView) findViewById(R.id.feet_text_view);
        yardTextView = (TextView) findViewById(R.id.yard_text_view);
        stajaTextView = (TextView) findViewById(R.id.staja_text_view);
    }

    public void addItemToUnitTypeSpinner(){
        unitTypeSpinner = (Spinner) findViewById(R.id.unit_type_spinner);
        ArrayAdapter<CharSequence> unitTypeSpinnerAdapter =
                ArrayAdapter.createFromResource(this, R.array.conversion_types,
                        android.R.layout.simple_spinner_item);
        unitTypeSpinnerAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        unitTypeSpinner.setAdapter(unitTypeSpinnerAdapter);
    }

    public void addListenerToUnitTypeSpinner(){
        unitTypeSpinner = (Spinner) findViewById(R.id.unit_type_spinner);
        unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelectedSpinner = parent.getItemAtPosition(position).toString();
                checkIfConversionFromMetres(itemSelectedSpinner);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
