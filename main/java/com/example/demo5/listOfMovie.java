package com.example.demo5;

import javafx.scene.control.ListView;

import java.util.List;

public class listOfMovie {

    public ListView recentmovieslist;

    public void show(List<Movie>movielist)
    {
        int i;
        for(i=0;i<movielist.size();i++)
        {

            recentmovieslist .getItems().add(movielist.get(i).movie_print());


        }


    }

}
