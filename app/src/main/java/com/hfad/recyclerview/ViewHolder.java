package com.hfad.recyclerview;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private ImageView featuredImage;
    private TextView title;
    private TextView desc;
    private AppCompatButton btnLink;

    public ImageView getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(ImageView featuredImage) {
        this.featuredImage = featuredImage;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getDesc() {
        return desc;
    }

    public void setDesc(TextView desc) {
        this.desc = desc;
    }

    public AppCompatButton getBtnLink() {
        return btnLink;
    }

    public void setBtnLink(AppCompatButton btnLink) {
        this.btnLink = btnLink;
    }

    public ViewHolder(View itemView) {
        super(itemView);

        this.featuredImage = itemView.findViewById(R.id.featuredImage);
        this.title = itemView.findViewById(R.id.title);
        this.desc = itemView.findViewById(R.id.desc);
        this.btnLink = itemView.findViewById(R.id.btnLink);
    }

}
