package com.example.admin.week2thursdayhw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseActivity extends AppCompatActivity {
    List<KiwiObject> kiwiList = new ArrayList<KiwiObject>();
    private static final String TAG = "HomeActivityTAG";
    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    EditText etFirstName, etLastName, etCell, etNotes,
            etFirstNameUpdate, etLastNameUpdate, etCellUpdate, etNotesUpdate;
    TextView tvGetView;
    Spinner spinnerGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etCell = (EditText) findViewById(R.id.etCell);
        etNotes = (EditText) findViewById(R.id.etNotes);

        etFirstNameUpdate = (EditText) findViewById(R.id.etFirstNameUpdate);
        etLastNameUpdate = (EditText) findViewById(R.id.etLastNameUpdate);
        etCellUpdate = (EditText) findViewById(R.id.etCellUpdate);
        etNotesUpdate = (EditText) findViewById(R.id.etNotesUpdate);

        tvGetView = (TextView) findViewById(R.id.tvGetView);
        spinnerGet = (Spinner) findViewById(R.id.spinnerGet);


        updateFirstSpinner();
        getData();
    }

    public void updateFirstSpinner() {
        try {
            kiwiList = databaseHelper.getAllInformation();
            List<String> list = new ArrayList<String>();


            for (int i = 0; i < kiwiList.size(); i++) {
                list.add(kiwiList.get(i).getKIWI_FIRSTNAME());
            }
            if (list.size() == 0) {
                list.add("Add new Data");
            }


            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerGet.setAdapter(dataAdapter);
        } catch (Exception e) {
            Log.d(TAG, "onCreateDatabaseAc: " + e.toString());
        }
    }

    public void databaseAccess(View view) {
        switch (view.getId()) {

            //CREATE
            case R.id.btnSaveData:
                Log.d(TAG, "databaseAccessSAVEDATA: ");
                try {
                    databaseHelper.saveKiwi(etFirstName.getText().toString(), etLastName.getText().toString(),
                            Integer.parseInt(etCell.getText().toString()),
                            etNotes.getText().toString());
                    updateFirstSpinner();
                } catch (Exception e) {
                    Log.d(TAG, "databaseAccess err: " + e.toString());
                }
                break;

            //READ
            case R.id.btnGetData:
                getData();
                break;

            //UPDATE
            case R.id.btnUpdatetData:
                Log.d(TAG, "database Update: ");
                try {
                    int b = (int) spinnerGet.getSelectedItemId();
                    databaseHelper.updateKiwi(kiwiList.get(b).KIWI_ID,
                            etFirstNameUpdate.getText().toString(),
                            etLastNameUpdate.getText().toString(),
                            Integer.parseInt(etCellUpdate.getText().toString()),
                            etNotesUpdate.getText().toString());
                    updateFirstSpinner();
                } catch (Exception e) {
                    Log.d(TAG, "database Update ex: " + e.toString());
                }
                getData();
                break;

            //DELETE
            case R.id.btnDeletetData:
                try {
                    int b = (int) spinnerGet.getSelectedItemId();
                    databaseHelper.delete(kiwiList.get(b).KIWI_ID);
                    updateFirstSpinner();
                } catch (Exception e) {

                }
                getData();
                break;
        }
    }

    public void getData() {
        try {
            int a = (int) spinnerGet.getSelectedItemId();
            Log.d(TAG, "databaseAccessGETDATA: " + kiwiList.get(a));
            tvGetView.setText(kiwiList.get(a).toString());


            etFirstNameUpdate.setText(kiwiList.get(a).getKIWI_FIRSTNAME().toString());
            etLastNameUpdate.setText(kiwiList.get(a).getKIWI_LASTNAME().toString());
            etCellUpdate.setText(String.valueOf(kiwiList.get(a).getKIWI_CELL()));
            etNotesUpdate.setText(kiwiList.get(a).getKIWI_NOTE().toString());
        } catch (Exception e) {
            Log.d(TAG, "databaseAccess: ");
        }
    }

}

