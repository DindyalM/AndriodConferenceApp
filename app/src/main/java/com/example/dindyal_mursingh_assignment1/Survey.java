package com.example.dindyal_mursingh_assignment1;

import android.arch.persistence.room.PrimaryKey;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Survey extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private Button btnSave;
    private CharSequence ans1 , ans2, ans3;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        radioGroup = (RadioGroup) findViewById(R.id.rg1);
        radioGroup2 = (RadioGroup) findViewById(R.id.rg2);
        radioGroup3 = (RadioGroup) findViewById(R.id.rg3);

        btnSave = (Button) findViewById(R.id.buttonSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checked1 , checked2, checked3;
                RadioButton radioButton;

                checked1 =radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton)findViewById(checked1);
                ans1 = radioButton.getText();

                checked2 = radioGroup2.getCheckedRadioButtonId();
                radioButton = (RadioButton)findViewById(checked2);
                ans2 = radioButton.getText();

                checked3 = radioGroup2.getCheckedRadioButtonId();
                radioButton = (RadioButton)findViewById(checked3);
                ans3 = radioButton.getText();

                context = v.getContext();
                writeToFile(context,ans1.toString(), ans2.toString(), ans3.toString());

            }
        });
    }
    private void writeToFile(Context context, String s, String s2, String s3) {
        try {
            Long tsLong = System.currentTimeMillis();
            String ts = tsLong.toString();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String ts2 = formatter.format(new Date(Long.parseLong(ts)));


            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("survey.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(s +" " + s2 + " " + s3 + " saved at s" + ts2 +" ,");
            outputStreamWriter.close();


            Toast.makeText(this, "file saved /data/data/com.example.dindyal_mursingh_assignment1/files/survey.txt",
                    Toast.LENGTH_LONG).show();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
