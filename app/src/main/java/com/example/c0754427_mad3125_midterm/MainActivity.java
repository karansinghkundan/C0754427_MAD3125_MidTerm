package com.example.c0754427_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataStore mDataSource = new DataStore(MainActivity.this);
        mDataSource.processJSON();
        Log.d("Size of List : ---->",String.valueOf(mDataSource.mSpaceXFlightList.size()));


    }
}
