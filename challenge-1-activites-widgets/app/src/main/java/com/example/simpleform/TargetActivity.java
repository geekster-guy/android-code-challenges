package com.example.simpleform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity {

    TextView targetTVObjMag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        targetTVObjMag = findViewById(R.id.textViewDisplay);
        Intent currentIntent = getIntent();

        Boolean chkStudy;
        Boolean chkWork;
        Boolean chkTrain;
        String edtxName;

        chkStudy = currentIntent.getBooleanExtra("chkbxStudy", false);
        chkWork = currentIntent.getBooleanExtra("chkbxWork", false);
        chkTrain = currentIntent.getBooleanExtra("chkbxTrain", false);
        edtxName = currentIntent.getStringExtra("edtxName");

        targetTVObjMag.setText("User name: " + edtxName + "\n" +
                                "\nThe user is working? " + Boolean.toString(chkWork) + "\n" +
                                "The user is studying? " + Boolean.toString(chkStudy) + "\n" +
                                "The user is in training? " + Boolean.toString(chkTrain));

    }
}