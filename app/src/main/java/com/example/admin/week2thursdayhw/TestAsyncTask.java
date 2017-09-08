package com.example.admin.week2thursdayhw;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Admin on 9/7/2017.
 */

public class TestAsyncTask extends AsyncTask<Void, Integer, Void> {

        ProgressBar myProgressBar;

        public TestAsyncTask(ProgressBar target) {
            myProgressBar = target;
        }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


        @Override
        protected Void doInBackground(Void... params) {
            for(int i=0; i<100; i++){

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }

            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            myProgressBar.setProgress(values[0]);
        }

    }
