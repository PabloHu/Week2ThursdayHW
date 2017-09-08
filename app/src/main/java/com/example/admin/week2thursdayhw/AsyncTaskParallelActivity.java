package com.example.admin.week2thursdayhw;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncTaskParallelActivity extends Activity {


    Button buttonStart;
    ProgressBar progressBar1, progressBar2, progressBar3;
    TestAsyncTask asyncTask1, asyncTask2, asyncTask3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_parallel);
        progressBar1 = (ProgressBar)findViewById(R.id.progressbar1);
        progressBar2 = (ProgressBar)findViewById(R.id.progressbar2);
        progressBar3 = (ProgressBar)findViewById(R.id.progressbar3);


        buttonStart = (Button)findViewById(R.id.start);
        buttonStart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                asyncTask1 = new TestAsyncTask(progressBar1);
                asyncTask1.execute();
                asyncTask2 = new TestAsyncTask(progressBar2);
                StartAsyncTaskParallel(asyncTask2);
                asyncTask3 = new TestAsyncTask(progressBar3);
                StartAsyncTaskParallel(asyncTask3);



            }});

    }


    private void StartAsyncTaskParallel(TestAsyncTask task) {
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

}