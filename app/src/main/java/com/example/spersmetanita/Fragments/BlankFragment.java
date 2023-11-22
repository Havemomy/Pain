package com.example.spersmetanita.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.spersmetanita.Film;
import com.example.spersmetanita.FilmAdapter;
import com.example.spersmetanita.R;
import com.example.spersmetanita.databinding.FragmentBlankBinding;

import java.util.ArrayList;

public class BlankFragment extends Fragment {

    public BlankFragment() {
    }

    ArrayList<Film> film = new ArrayList<>();
    private FragmentBlankBinding binding;
    public FilmAdapter filmAdapter;

    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void setInitialData() {
        FragmentActivity activity = requireActivity();
        Context context = requireContext();
        binding.loadBar.setVisibility(View.VISIBLE);
        binding.filmList.setVisibility(View.GONE);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (film.size() == 0) {
                    film.add(new Film("Шрэк", 2001, R.drawable.shrek1));
                    film.add(new Film("Шрэк 2", 2004, R.drawable.shrek2));
                    film.add(new Film("Шрэк 3", 2007, R.drawable.shrek3));
                    film.add(new Film("Твое имя", 2014, R.drawable.tvoyeimya));
                    film.add(new Film("Дитя погоды", 2017, R.drawable.dityapogodi));
                }

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView textView = binding.selection;
                        binding.loadBar.setVisibility(View.GONE);
                        binding.filmList.setVisibility(View.VISIBLE);
                        filmAdapter = new FilmAdapter(context,
                                R.layout.list_item, film);
                        binding.filmList.setAdapter(filmAdapter);
                    }
                });
            }
        });
        thread.start();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView filmlist = view.findViewById(R.id.filmList);
        TextView selection = view.findViewById(R.id.selection);
        setInitialData();
        filmlist.setAdapter(filmAdapter);
        ShowNewFilmFragment();
        ShowSettingsFragment();
    }

    public void ShowNewFilmFragment() {
        binding.addFilm.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_view, new NewFilmFragment(filmAdapter), "new_film_fragment")
                    .addToBackStack("new_film_fragment")
                    .commit();
        });
    }

    public void ShowSettingsFragment() {
        binding.btnStettings.setOnClickListener(view -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_view, new SettingsFragment(filmAdapter), "settigns_fragment")
                    .addToBackStack("settigns_fragment")
                    .commit();
        });
    }

}