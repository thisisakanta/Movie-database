package com.example.demo5;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class Listviewofgenre {


    public ListView listviewGenre;
    public void search(List<Movie> movielist,String username)
    {int index;
        List<Movie>  printMovies=new ArrayList();
        for (int i = 0; i < movielist.size(); i++) {
            Movie m = movielist.get(i);
            String[] out = m.get_genre().split(",");
            for (int o = 0; o < out.length; o++) {
                if (out[o].toUpperCase().equals(username.toUpperCase())) {
                    index=i;
                    printMovies.add(movielist.get(i));
                    break;
                }
            }

        }




        int i;
        for(i=0;i<printMovies.size();i++)
        {

            listviewGenre.getItems().add(printMovies.get(i).movie_print());


        }


    }

}

