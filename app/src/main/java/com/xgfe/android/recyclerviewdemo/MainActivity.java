package com.xgfe.android.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private RecyclerView recyclerView;
    private boolean checked;

    private CustomAdapter adapter = new CustomAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerView);

        button.setOnClickListener(v -> {
            recyclerView.setVisibility(checked ? View.GONE : View.VISIBLE);
            checked = !checked;
        });

        recyclerView.setLayoutManager(new CustomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.addItemDecoration(new CustomItemDecoration(5, 15, 15, 10, 0));
        recyclerView.setItemViewCacheSize(10);
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
}
