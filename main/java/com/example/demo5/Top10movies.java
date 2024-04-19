package com.example.demo5;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class Top10movies {

@FXML
    public ListView topMovies;
    public void show(List<Movie> movielist)
    {

        for (int i = 0; i < movielist.size() - 1; i++) {

            for (int q = i + 1; q < movielist.size(); q++) {
                Movie m = movielist.get(i);
                Movie dada = movielist.get(q);
                if ((m.get_revenue() - m.get_budget()) < (dada.get_revenue() - m.get_budget())) {
                    Movie temp = movielist.get(i);
                    movielist.set(i, movielist.get(q));
                    movielist.set(q, temp);


                }


            }


        }
        List<Movie>  printMovies=new ArrayList();
        for (int i = 0; i < 10; i++) {
            printMovies.add(movielist.get(i));
        }


int i;
        for(i=0;i<printMovies.size();i++)
        {

            topMovies.getItems().add(printMovies.get(i).movie_print());


        }


    }



    }



