package com.example.spersmetanita.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.spersmetanita.R;
import com.example.spersmetanita.Film;
import com.example.spersmetanita.FilmAdapter;
import com.example.spersmetanita.databinding.NewFillmBinding;

import java.util.Random;


public class NewFilmFragment extends Fragment {
    private NewFillmBinding binding;

    private FilmAdapter adapter;

    public NewFilmFragment(FilmAdapter adapter) {

        this.adapter = adapter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = NewFillmBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addFilm();
        initClose();
    }
    private void initClose() {
        binding.btnClose.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager()
                    .popBackStack();
        });
    }
    private void addFilm() {
        binding.btnAdd.setOnClickListener((v) -> {
            String filmName = binding.addName.getText().toString();
            int filmYear = Integer.valueOf(binding.addYear.getText().toString());
            Random randphoto = new Random();
            int photoId;
            switch (randphoto.nextInt(5)) {
                case 1:
                    photoId = R.drawable.shrek1;
                    break;
                case 2:
                    photoId = R.drawable.shrek2;
                    break;
                case 3:
                    photoId = R.drawable.shrek3;
                case 4:
                    photoId = R.drawable.tvoyeimya;
                    break;
                default:
                    photoId = R.drawable.dityapogodi;
            }
            if (filmYear == 0 || filmName.equals("")) return;
            Film Film2Add = new Film(filmName, filmYear, photoId);
            if (adapter == null) {
                Log.d("WARN", "АДАПТЕР ПУСТ");
            }
            adapter.add(Film2Add);
            requireActivity().getSupportFragmentManager().popBackStack();
        });
    }































     //   public static NewFilmFragment getInstance(List<State> tasks) {
     //       NewFilmFragment fragment = new NewFilmFragment();
     //       Bundle args = new Bundle();
      //      args.putSerializable(ARG_TASKS, (Serializable) tasks);
      //      fragment.setArguments(args);
      //      return fragment;
      //  }

    //public void onCreate(Bundle savedInstanceState) {
   //     super.onCreate(savedInstanceState);
   //     if (getArguments()!=null){
   //         tasks = (List<State>) getArguments().getSerializable(ARG_TASKS);
    //    }
   // }
}
