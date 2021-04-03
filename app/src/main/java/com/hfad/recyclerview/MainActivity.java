package com.hfad.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.Callback;
import com.pkmmte.pkrss.PkRSS;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<Article> list = new ArrayList<Article>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerAdapter = new RecyclerAdapter(list);
        recyclerView.setAdapter(recyclerAdapter);

        PkRSS.with(this).load("http://www.androidpro.com.br/feed/").skipCache().callback(this).async();
    }

    @Override
    public void onPreload() {

    }

    @Override
    public void onLoaded(List<Article> newArticles) {
        list.clear();
        list.addAll(newArticles);
        recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadFailed() {

    }

}
