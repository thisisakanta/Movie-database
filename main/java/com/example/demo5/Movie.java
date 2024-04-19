package com.example.demo5;

import java.io.Serializable;

public class Movie implements Serializable {

    private String movie_title;
    private int release_year;

    private String genre;
    private int run_time;
    private String pro_company;
    private int Budget;
    private int Revenue;

    public Movie(String movie_title,int release_year,String genre,int run_time,String pro_company,int Budget,int Revenue)

    {
        this.movie_title = movie_title;
        this.release_year = release_year;
        this.genre = genre;
        this.run_time = run_time;
        this.pro_company = pro_company;
        this.Budget = Budget;
        this.Revenue = Revenue;


    }


    public void set_movie_title(String s) {
        this.movie_title = s;

    }

    public void set_release_year(int yr) {
        this.release_year = yr;

    }

    public void set_genre(String g) {
        this.genre = g;

    }

    public void set_runtime(int r) {
        this.run_time = r;

    }

    public void set_production_company(String p) {
        this.pro_company = p;

    }

    public void set_budget(int b) {
        this.Budget = b;

    }

    public void set_revenue(int r) {
        this.Revenue=r;

    }

    public int get_budget() {
        return this.Budget;

    }

    public int get_revenue() {
        return this.Revenue;

    }

    public int get_release_year() {
        return this.release_year;

    }

    public int get_runtime() {
       return  this.run_time;

    }

    public String get_movie_title() {
       return  this.movie_title;

    }

    public String get_genre() {
        return this.genre;

    }

    public String get_production_company() {
        return this.pro_company;

    }

    public String movie_print()
    {
        String username="Movie Title ="+" "+movie_title+"\n"+"Release Year ="+" "+release_year+"\n"+"Genre ="+" "+genre+"\n"+"Run Time ="+ " "+run_time+"\n"+"Production Company ="+" "+ pro_company+"\n"+"Budget =" +" "+Budget+"\n"+"Revenue ="+" "+Revenue;
        return username;

    }
}
