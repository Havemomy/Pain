package com.example.spersmetanita;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class FilmAdapter extends ArrayAdapter<Film> {

    private LayoutInflater inflater;
    private int layout;
    private List<Film> films;

    public FilmAdapter(Context context, int resource, List<Film> films) {
        super(context, resource, films);
        this.films = films;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=inflater.inflate(this.layout, parent, false);
        ImageView posterView = view.findViewById(R.id.poster);
        TextView nameView = view.findViewById(R.id.name);
        TextView yearView = view.findViewById(R.id.year);
        Film film = films.get(position);
        Drawable poster = getContext().getDrawable(film.getPosterResource());
        posterView.setImageDrawable(poster);
        nameView.setText(
                String.format(getContext().getString(R.string.film_name), film.getName())
        );
        yearView.setText(
                String.format(getContext().getString(R.string.film_year), film.getYear())
        );

        return view;
    }

    @Override
    public void add(@Nullable Film object) {
        super.add(object);
    }
}
