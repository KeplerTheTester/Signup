package com.one.johnsmith.signup;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FillOutPrompt extends AppCompatActivity
{
    //a thing that will prompt them if they would like to use their own account info
    public static boolean AskAgain_prompt = true;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_out_prompt);
        EditText phone = (EditText) findViewById(R.id.Phone_editText);
        EditText Email = (EditText) findViewById(R.id.Email_editText);
        EditText Name = (EditText) findViewById(R.id.Name_editText);
        AlertDialog.Builder mBuilder= new AlertDialog.Builder(FillOutPrompt.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_login, null);
        final EditText thing = (EditText) mView.findViewById(R.id.Test_editText);
        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        if(AskAgain_prompt == true) {
            dialog.show();
            final Button close = (Button) mView.findViewById(R.id.no_button);
            final CheckBox DoNotCheckBox = (CheckBox) mView.findViewById(R.id.checkBox);

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    }

    public void onCheckboxClicked(View view)
    {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBox:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "Checked", Toast.LENGTH_SHORT).show();
                    AskAgain_prompt = false;
                    break;
                }
            else
                // Remove the meat
                break;
        }
    }

}
