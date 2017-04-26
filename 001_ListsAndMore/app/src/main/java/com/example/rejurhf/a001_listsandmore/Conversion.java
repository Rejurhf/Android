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

    public void checkIfConversionFromMetres(String currentUnit){
        if (currentUnit.equals("metres")){
            updateUnitTypeUsingMetres(Quantity.Unit.metres);
        }else{
            if (currentUnit.equals("mile")){
                updateUnitTypeUsingOther(Quantity.Unit.mile);
            }else if (currentUnit.equals("inch")){
                updateUnitTypeUsingOther(Quantity.Unit.inch);
            }else if (currentUnit.equals("feet")){
                updateUnitTypeUsingOther(Quantity.Unit.feet);
            }else if (currentUnit.equals("yard")){
                updateUnitTypeUsingOther(Quantity.Unit.yard);
            }else{
                updateUnitTypeUsingOther(Quantity.Unit.staja);
            }
        }
    }

    public void updateUnitTypeUsingMetres(Quantity.Unit currentUnit){
        double doubleToCOnvert = Double.parseDouble(inputEditText.getText().toString());
        String metresValueString = doubleToCOnvert + " metres";
        metresTextView.setText(metresValueString);

        updateUnitTextFieldUsingMetres(doubleToCOnvert, Quantity.Unit.mile, mileTextView);
        updateUnitTextFieldUsingMetres(doubleToCOnvert, Quantity.Unit.inch, inchTextView);
        updateUnitTextFieldUsingMetres(doubleToCOnvert, Quantity.Unit.feet, feetTextView);
        updateUnitTextFieldUsingMetres(doubleToCOnvert, Quantity.Unit.yard, yardTextView);
        updateUnitTextFieldUsingMetres(doubleToCOnvert, Quantity.Unit.staja, stajaTextView);
    }

    public void updateUnitTextFieldUsingMetres(double doubleToCOnvert,
                                               Quantity.Unit unitConvertTo, TextView theTextView){
        Quantity unitQuantity = new Quantity(doubleToCOnvert, Quantity.Unit.metres);
        String tmpTextView = unitQuantity.to(unitConvertTo).toString();
        theTextView.setText(tmpTextView);
    }

    public void updateUnitTypeUsingOther(Quantity.Unit currentUnit){
        double doubleToConvert = Double.parseDouble(inputEditText.getText().toString());
        Quantity currentQuantitySeleccted = new Quantity(doubleToConvert, currentUnit);
        String valueInMetres = currentQuantitySeleccted.to(Quantity.Unit.metres).toString();
        metresTextView.setText(valueInMetres);

        updateUnitTextFieldUsingMetres(doubleToConvert, currentUnit,
                Quantity.Unit.mile, mileTextView);
        updateUnitTextFieldUsingMetres(doubleToConvert, currentUnit,
                Quantity.Unit.inch, inchTextView);
        updateUnitTextFieldUsingMetres(doubleToConvert, currentUnit,
                Quantity.Unit.feet, feetTextView);
        updateUnitTextFieldUsingMetres(doubleToConvert, currentUnit,
                Quantity.Unit.yard, yardTextView);
        updateUnitTextFieldUsingMetres(doubleToConvert, currentUnit,
                Quantity.Unit.staja, stajaTextView);

        if (currentUnit.name().equals(currentQuantitySeleccted.unit.name())){
            String currentUnitText = doubleToConvert + " " + currentQuantitySeleccted.unit.name();
            String currentTextViewName = currentQuantitySeleccted.unit.name() + "_text_view";
            int currentId = getResources().getIdentifier(currentTextViewName, "id",
                    Conversion.this.getPackageName());
            TextView currentTextView = (TextView) findViewById(currentId);
            currentTextView.setText(currentUnitText);
        }
    }

    public void updateUnitTextFieldUsingMetres(double doubleToCOnvert, Quantity.Unit currentUnit,
                                               Quantity.Unit unitConvertTo, TextView theTextView){
        Quantity currentQuantitySelected = new Quantity(doubleToCOnvert, currentUnit);
        String tmpTextView =
                currentQuantitySelected.to(Quantity.Unit.metres).to(unitConvertTo).toString();
        theTextView.setText(tmpTextView);
    }
}
