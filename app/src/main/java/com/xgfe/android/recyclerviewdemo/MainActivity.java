package com.xgfe.android.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.amap.api.maps2d.MapView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private boolean checked;
    private MapView mapView;

    private CustomAdapter adapter = new CustomAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        mapView = findViewById(R.id.mapView);

        mapView.onCreate(savedInstanceState);

        mapView.getChildAt(0).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("RVDemo", "mapView child onTouch, " + event.toString());
                return false;
            }
        });

        mapView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("RVDemo", "mapView onTouch, " + event.toString());
                return false;
            }
        });

        recyclerView.setLayoutManager(new CustomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.addItemDecoration(new CustomItemDecoration(5, 15, 15, 10, 0));
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("RVDemo", "recyclerView onTouch, " + event.toString());

                return false;
            }
        });


        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.e("RVDemo", "recyclerView onInterceptTouchEvent, " + e.toString());
                return true;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.e("RVDemo", "recyclerView onTouchEvent, " + e.toString());
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        Log.e("RVDemo", "map view child count: " + mapView.getChildCount());


//        recyclerView.setItemViewCacheSize(10);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);
        adapter.setData(buildData());
    }

    private List<String> buildData() {
        List<String> list = new ArrayList<>();
        list.add("1测试测试");
        list.add("2测试测试测试");

        list.add("3测试测试测试测试测试");
        list.add("4测试");
        list.add("5测试测试测试测试测试测试测试测试");
        list.add("6测试测试测试测试测试测试测试测试测试测试测试");
        list.add("7测试测试测试测试测试测试测试测试");
        return list;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("RVDemo", "MainActivity dispatchTouchEvent, " + ev.toString());
        return super.dispatchTouchEvent(ev);
    }
}
