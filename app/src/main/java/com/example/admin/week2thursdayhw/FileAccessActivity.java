package com.example.admin.week2thursdayhw;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import static android.R.attr.data;
import static android.R.attr.scaleGravity;

public class FileAccessActivity extends AppCompatActivity {

    private static final String TAG = "FileAccessActivityTAG";
    final String fileLocation = "/storage/emulated/0/Download/kiwi.txt";
    EditText etFileString;
    TextView tvFileView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_access);
        etFileString=(EditText) findViewById(R.id.etFileString);
        tvFileView = (TextView) findViewById(R.id.tvFileView);
    }

    public void FileAccess(View view) {
        switch ((view.getId())){
            case R.id.btnSaveIntoFile:
                createFile(fileLocation);
                writeOnFile(fileLocation, etFileString.getText().toString());
                break;
            case R.id.btnGetFromFile:

                BufferedReader br = null;
                FileReader fr = null;

                try {
                    fr = new FileReader(fileLocation);
                    br = new BufferedReader(fr);

                    String sCurrentLine;

                    while ((sCurrentLine = br.readLine()) != null) {
                        Log.d(TAG, "FileAccess: " + sCurrentLine);
                        tvFileView.setText(sCurrentLine);
                    }
                }
                catch (Exception e)
                {
                    Log.d(TAG, "FileAccess err: "+e.toString());
                }
                break;
        }}

    private void writeOnFile(String fileLocation, String stringToSave) {

        try{
            File file = new File(fileLocation);
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);
            pw.println(stringToSave);
            pw.flush();
            pw.close();

            f.close();
        } catch (IOException e) {
            Log.d(TAG, "FileAccess NOTE SAVE: " + e.toString());
        }
    }

    public void createFile(String fileLocation){
        Log.d(TAG, "FileAccess save: ");
        File file = new File(fileLocation);
        try {
            file.createNewFile();
            Log.d(TAG, "FileAccess saved!!!!!: ");
        } catch (IOException e) {
            Log.d(TAG, "FileAccess save err: "+e.toString());
        }
    }
    }
