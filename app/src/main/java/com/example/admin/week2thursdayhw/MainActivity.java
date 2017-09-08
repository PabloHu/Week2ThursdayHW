package com.example.admin.week2thursdayhw;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Intent HwIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Daily 2
Create an application that
1. Save some data to the file and then read it from that file(File class) to update the textview.
2. Creates a database with at least five columns, the activity should have all the fields required in the database and perform all the CRUD operations
3. Start multiple AsyncTask in parallel.
         */


    }

    public void HomeworkType(View view) {
        switch(view.getId()){
            case R.id.btnFileHW:
                HwIntent = new Intent(this, FileAccessActivity.class);
                startActivity(HwIntent);
                break;

            case R.id.btnDatabaseHW:
                HwIntent  = new Intent(this, DatabaseActivity.class);
                startActivity(HwIntent);
                break;

            case R.id.btnAsyncTask:
                HwIntent  = new Intent(this, AsyncTaskParallelActivity.class);
                startActivity(HwIntent);
                break;

        }
    }
}
