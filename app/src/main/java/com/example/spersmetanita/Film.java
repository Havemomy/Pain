package com.example.spersmetanita;

import androidx.annotation.DrawableRes;

public class Film {

    private String name;
    private int year;
    @DrawableRes
    private int posterResource;

    public Film(String name, int year,
                @DrawableRes int poster){

        this.name=name;
        this.year=year;
        this.posterResource=poster;
    }

    public String getName() {
        return this.name;
    }
    public int getYear() {
        return this.year;
    }
    @DrawableRes
    public int getPosterResource() {
        return this.posterResource;
    }


}
