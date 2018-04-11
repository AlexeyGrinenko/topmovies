package com.alexg.topmovies.topmovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexg.topmovies.models.DataMovieModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.ListItemViewHolder> {

    private final String BASE_URL = "https://image.tmdb.org/t/p/w500";

    private List<DataMovieModel> list;

    public MoviesListAdapter(List<DataMovieModel> list) {
        this.list = list;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {

        holder.itemName.setText(list.get(position).getName());
        holder.countryName.setText(list.get(position).getCountry());

        Picasso.with(holder.posterView.getContext())
                .load(BASE_URL + list.get(position).getPoster())
                .resize(100, 100)
                .centerInside()
                .into(holder.posterView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder {

        public TextView itemName;
        public TextView countryName;
        public ImageView posterView;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.textView_item_movie_name);
            countryName = itemView.findViewById(R.id.textView_item_movie_country);
            posterView = itemView.findViewById(R.id.imageView_item_movie);
        }
    }
}

