package com.example.demo5;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListviewofProduction {


    public ListView myproduction;

    public void search(List<Movie> movielist, String username)
    {
        int index=-1;
        List<Movie>  printMovies=new ArrayList();
        for (int i = 0; i < movielist.size(); i++) {
            Movie m = movielist.get(i);
            if (m.get_production_company().toUpperCase().equals(username.toUpperCase())) {
                printMovies.add(movielist.get(i));

            }


        }

        int i;
        for(i=0;i<printMovies.size();i++)
        {

            myproduction.getItems().add(printMovies.get(i).movie_print());


        }


    }



}
