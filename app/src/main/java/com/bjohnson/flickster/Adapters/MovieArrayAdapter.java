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

    private static class ViewHolder {
        TextView title;
        TextView description;
        ImageView poster;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Movie movie = getItem(position);

        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);

            viewHolder.poster = convertView.findViewById(R.id.ivMovieImage);
            viewHolder.title = convertView.findViewById(R.id.tvTitle);
            viewHolder.description = convertView.findViewById(R.id.tvOverview);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.poster.setImageResource(0);
        viewHolder.title.setText(movie.getOrigialTitle());
        viewHolder.description.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).
                fit().centerCrop().placeholder(R.drawable.placeholder).into(viewHolder.poster);
        return convertView;
    }
}
