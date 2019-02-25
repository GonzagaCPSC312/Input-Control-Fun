package com.example.gsprint.inputcontrolfun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            // need to restore counter
            counter = savedInstanceState.getInt("counter");
            updateCounterTextView();
        }

        // get a reference to seek bar and add a change listener
        SeekBar seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // i corresponds to the progress value
                // b corresponds to change from the user or not
                Log.d(TAG, "onProgressChanged: " + i);
                // task: what are default values for min/max progress? [0, 100]
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void buttonClicked(View view) {
        counter++;
        updateCounterTextView();
    }

    private void updateCounterTextView() {
        // Task: get a reference to our TextView and update it accordingly
        TextView textView = (TextView) findViewById(R.id.counterTextView);
        textView.setText("Count: " + counter);
    }

    // override onSaveInstanceState()

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // saves the state of our views
        // however, doesnt save state of textview
        // so we need to manually save the value of counter
        // and restore it in onCreate() (or in onRestoreInstanceState())

        // save counter in Bundle
        outState.putInt("counter", counter);

    }

    public void toggleButtonClicked(View view) {
        // we know view is a ToggleButton
        ToggleButton toggleButton = (ToggleButton) view;
        // we can find out it it is "checked" or not
        if (toggleButton.isChecked()) {
            // on state
            Toast.makeText(this, "Toggle button on", Toast.LENGTH_SHORT).show();
        }
        else {
            // off state
            Toast.makeText(this, "Toggle button off", Toast.LENGTH_SHORT).show();
        }
    }

    public void switchButtonClicked(View view) {
        // we know view is a Switch
        Switch switchButton = (Switch) view;
        // we can find out it it is "checked" or not
        if (switchButton.isChecked()) {
            // on state
            Toast.makeText(this, "Switch button on", Toast.LENGTH_SHORT).show();
        }
        else {
            // off state
            Toast.makeText(this, "Switch button off", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkboxClicked(View view) {
        // which checkbox is view referring to
        int checkboxID = view.getId();
        // use if statements or a switch to do this
        switch(checkboxID) {
            case R.id.milkCheckBox:
                // write a message to the logs
                Log.d(TAG, "checkboxClicked: Milk state changed");
                // task: add code to find out if the checkbox is checked or not
                break;
            case R.id.creamCheckBox:
                Log.d(TAG, "checkboxClicked: Cream state changed");
                break;
            case R.id.sugarCheckBox:
                Log.d(TAG, "checkboxClicked: Sugar state changed");
                break;
        }
    }

    public void radiobuttonClicked(View view) {
        // task: add code to write to the logs about which radio button was clicked
        // let's get a reference to RadioGroup
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.classStandingRadioGroup);
        int radioButtonID = radioGroup.getCheckedRadioButtonId(); // this will tell us which
        // radiobutton is checked
        // finish code here...
    }

}
