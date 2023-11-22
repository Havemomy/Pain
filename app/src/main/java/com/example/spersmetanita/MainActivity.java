package com.example.spersmetanita;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;

import com.example.spersmetanita.Fragments.BlankFragment;
import com.example.spersmetanita.Fragments.SettingsFragment;


public class MainActivity extends AppCompatActivity {
    @NonNull
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragMan = getSupportFragmentManager();
        if (fragMan.getBackStackEntryCount() < 1) {
            fragMan
                    .beginTransaction()
                    .add(R.id.fragment_view, new BlankFragment(), "blank_fragment")
                    .commit();
        }
        SharedPreferences prefs = getSharedPreferences(SettingsFragment.PREFS,
                Context.MODE_PRIVATE);
        boolean darkTheme = prefs.getBoolean(SettingsFragment.DARK_QQQQ, false);
        if (darkTheme)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}