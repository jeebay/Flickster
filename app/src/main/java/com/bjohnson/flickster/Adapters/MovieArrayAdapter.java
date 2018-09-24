package com.bjohnson.flickster.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bjohnson.flickster.Models.Movie;
import com.bjohnson.flickster.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Movie movie = getItem(position);

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }


        ImageView ivImage = convertView.findViewById(R.id.ivMovieImage);
        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = convertView.findViewById(R.id.tvOverview);

        ivImage.setImageResource(0);
        tvTitle.setText(movie.getOrigialTitle());
        tvOverview.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).
                fit().centerCrop().placeholder(R.drawable.placeholder).into(ivImage);
        return convertView;
    }
}
