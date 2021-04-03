package com.hfad.recyclerview;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkmmte.pkrss.Article;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Article> list;

    public RecyclerAdapter(List<Article> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final Article article = list.get(i);

        viewHolder.getTitle().setText(article.getTitle());
        viewHolder.getDesc().setText(article.getAuthor());

        new DownloadImageTask(viewHolder.getFeaturedImage()).execute(article.getEnclosure().getUrl());

        viewHolder.getBtnLink().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, article.getSource());
                viewHolder.itemView.getContext().startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
