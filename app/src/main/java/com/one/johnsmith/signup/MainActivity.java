package com.one.johnsmith.signup;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    public Button testerButton;

    int userSelectedIndex =0;
    //Intent intent = new Intent(this, FillOutPrompt.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testerButton = (Button) findViewById(R.id.button2);
        setContentView(R.layout.activity_main);
        final Spinner spinner = (Spinner) findViewById(R.id.Sign_Up);
        //Spinner spinner = (Spinner) findViewById(R.id.Sign_Up);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Sign_up_pages, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                //Toast.makeText(getApplication(), "test", Toast.LENGTH_SHORT).show();
                if(parent.getItemAtPosition(position).toString().equals("Adult"))
                {
                    Toast.makeText(getApplication(), "adult matches", Toast.LENGTH_SHORT).show();
                }
                if(parent.getItemAtPosition(position).toString().equals("Sunday School"))
                {
                    Intent myIntent = new Intent(MainActivity.this, FillOutPrompt.class);
                    startActivity(myIntent);
                }
                userSelectedIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
}