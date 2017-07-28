package com.grademojo.recycler_view_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    private Adapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        // Step 1: Store recycler view's reference
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);




        // Step 2: Make adapter object
        List<Recycler_view_getter_setter> input = new ArrayList<>();

        for (int i = 0; i < 15; i++) {


            Recycler_view_getter_setter recycler_view_getter_setter = new Recycler_view_getter_setter();


            recycler_view_getter_setter.setRoll_no(""+i);
            recycler_view_getter_setter.setLeave("Leave"+i);
            recycler_view_getter_setter.setName("Name"+i);
            recycler_view_getter_setter.setAbsent("Absent"+i);
            recycler_view_getter_setter.setPresent("Present"+i);






            input.add(recycler_view_getter_setter);
        }
        mAdapter = new Adapter(input);





        // Step 3: bind the adapter to recycler view
        recyclerView.setAdapter(mAdapter);


        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);




        // Step 4: make a layout manager object
       // recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));

        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        //mLayoutManager = new LinearLayoutManager(this);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));



        // Step 5: bind the layoutManager object to recycler view
        recyclerView.setLayoutManager(mLayoutManager);




        // Optional stuff

    }
}
