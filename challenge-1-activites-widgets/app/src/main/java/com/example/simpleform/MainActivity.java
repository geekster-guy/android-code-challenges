package com.example.simpleform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Button buttonSendObjMag;
    private EditText editTextNameObjMag;
    private Switch switchAgreeObjMag;
    private CheckBox checkBoxStudyObjMag;
    private CheckBox checkBoxWorkObjMag;
    private CheckBox checkBoxTrainObjMag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSendObjMag = findViewById(R.id.buttonSend);
        editTextNameObjMag = findViewById(R.id.editTextName);
        switchAgreeObjMag = findViewById(R.id.switchAgree);
        checkBoxStudyObjMag = findViewById(R.id.checkBoxStudy);
        checkBoxWorkObjMag = findViewById(R.id.checkBoxWork);
        checkBoxTrainObjMag = findViewById(R.id.checkBoxTrain);

        buttonSendObjMag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean checkBoxes = checkBoxStudyObjMag.isChecked() || checkBoxWorkObjMag.isChecked() || checkBoxTrainObjMag.isChecked();

                if (switchAgreeObjMag.isChecked() && checkBoxes) {
                    Intent intent = new Intent(MainActivity.this, TargetActivity.class);
                    intent.putExtra("edtxName", editTextNameObjMag.getText().toString());
                    intent.putExtra("chkbxStudy", checkBoxStudyObjMag.isChecked());
                    intent.putExtra("chkbxWork", checkBoxWorkObjMag.isChecked());
                    intent.putExtra("chkbxTrain", checkBoxTrainObjMag.isChecked());
                    startActivity(intent);
                } else {
                    if (!switchAgreeObjMag.isChecked())
                        switchAgreeObjMag.setTextColor(0xffff0000);
                    else
                        switchAgreeObjMag.setTextColor(0xffffffff);
                    if (!checkBoxes) {
                        checkBoxStudyObjMag.setTextColor(0xffff0000);
                        checkBoxWorkObjMag.setTextColor(0xffff0000);
                        checkBoxTrainObjMag.setTextColor(0xffff0000);
                    } else {
                        checkBoxStudyObjMag.setTextColor(0xffffffff);
                        checkBoxWorkObjMag.setTextColor(0xffffffff);
                        checkBoxTrainObjMag.setTextColor(0xffffffff);
                    }
                }
            }
        });
    }
}