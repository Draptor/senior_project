package com.example.kylet.testingjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ShowLabsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private List<Lab> myData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_labs);
        mRecyclerView = findViewById(R.id.my_recycler_view);

        mRecyclerView.hasFixedSize();

        mAdapter = new MyAdapter(myData);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);

        prepareData();
    }

    private void prepareData(){
        Lab testLab = new Lab(19,41,1285,"CCI - Woodward 143");
        myData.add(testLab);

        testLab = new Lab(19,41,1285,"CCI - Woodward 120");
        myData.add(testLab);

        testLab = new Lab(19,41,1285,"CCI - Woodward 120");
        myData.add(testLab);

        testLab = new Lab(19,41,1285,"CCI - Woodward 120");
        myData.add(testLab);

        testLab = new Lab(19,41,1285,"CCI - Woodward 120");
        myData.add(testLab);

        testLab = new Lab(19,41,1285,"CCI - Woodward 120");
        myData.add(testLab);

        testLab = new Lab(19,41,1285,"CCI - Woodward 120");
        myData.add(testLab);
    }
}
