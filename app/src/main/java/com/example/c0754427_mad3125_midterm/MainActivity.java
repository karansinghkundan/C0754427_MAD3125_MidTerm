package com.example.c0754427_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FlightAdapter mAdapter;
    ImageView imageView;
    DataStore mDataStore;
    Button mButton;
    private List<Row> flightRowList = new ArrayList<>();
    public static ArrayList<SpaceXFlight> staticSpaceXFlightList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        mDataStore = new DataStore(MainActivity.this);
        mDataStore.processJSON();
        MainActivity.staticSpaceXFlightList = mDataStore.mSpaceXFlightList;
        Log.d("Size of SS space List :",String.valueOf(MainActivity.staticSpaceXFlightList.size()));
        Log.d("Size of mSpaceList:",String.valueOf(mDataStore.mSpaceXFlightList.size()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        recyclerView = findViewById(R.id.recyclerView);


        mAdapter = new FlightAdapter(this,flightRowList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareFlightListData();

    }

    private void prepareFlightListData()
    {
        for(SpaceXFlight flight : mDataStore.mSpaceXFlightList)
        { Row flightRow = new Row(flight.getLinks().getMission_patch_small(),flight.getMission_name(),flight.getLaunch_year());
            flightRowList.add(flightRow);
        }
        mAdapter.notifyDataSetChanged();
    }

}
