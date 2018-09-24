package com.bjohnson.flickster.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Movie {
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOrigialTitle() {
        return origialTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    String backdropPath;
    String posterPath;
    String origialTitle;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.overview = jsonObject.getString("overview");
        this.origialTitle = jsonObject.getString("original_title");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}