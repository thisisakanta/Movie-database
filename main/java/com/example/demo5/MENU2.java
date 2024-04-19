package com.example.demo5;

import java.util.ArrayList;
import java.util.List;

public class MENU2 {


    List<Movie> input1(List<Movie> movielist) {


        List<Movie> printMovies = new ArrayList();



        if(movielist.size()==1)
            return movielist;


        for (int i = 0; i < movielist.size() - 1; i++) {

            for (int q = i + 1; q < movielist.size(); q++) {
                Movie m = movielist.get(i);
                Movie dada = movielist.get(q);
                if ((m.get_release_year()) < (dada.get_release_year())) {
                    Movie temp = movielist.get(i);
                    movielist.set(i, movielist.get(q));
                    movielist.set(q, temp);


                }


            }
        }
        printMovies.add(movielist.get(0));
        for (int i = 1; i < movielist.size(); i++) {
            if (movielist.get(i).get_release_year() == movielist.get(i - 1).get_release_year())
                printMovies.add(movielist.get(i));
            else
                break;
        }

        return printMovies;

    }

   List<Movie> input2(List<Movie> movielist) {

       if(movielist.size()==1)
           return movielist;


        List<Movie> printMovies=new ArrayList<>();



            for (int i = 0; i < movielist.size() - 1; i++) {

                for (int q = i + 1; q < movielist.size(); q++) {
                    Movie m = movielist.get(i);
                    Movie dada = movielist.get(q);
                    if ((m.get_revenue()) < (dada.get_revenue())) {
                        Movie temp = movielist.get(i);
                        movielist.set(i, movielist.get(q));
                        movielist.set(q, temp);


                    }


                }
            }
   long max=movielist.get(0).get_revenue();
            int i=0;
            for ( i = 1; i < movielist.size(); i++) {
                if (movielist.get(i).get_revenue() == max)
                    printMovies.add(movielist.get(i));
                else
                    break;
            }
       printMovies.add(movielist.get(i));



        return printMovies;


    }



    /*    long input3( List<Movie> movielist) {
        System.out.println("NAME of the PRODUCTION COMPANY:");


        long sum = 0;
        for (int i = 0; i < movielist.size(); i++) {
            Movie m = movielist.get(i);
            if (m.get_production_company().toUpperCase().equals(input19.toUpperCase())) {
                sum = sum + (m.get_revenue() - m.get_budget());

            }


        }
        return sum;


    }

    HashMap <String,Integer> input4(List<Movie> movielist) {
        int i, j,p=0;
        HashMap<String,Integer> m=new HashMap<String,Integer>();
        for(i=0;i<movielist.size();i++)
        {
           if(m.containsKey(movielist.get(i).get_production_company())) {
               p =m.get( movielist.get(i).get_production_company() )+ 1;
               m.put(movielist.get(i).get_production_company(), p);
           }
           else
           {
               m.put(movielist.get(i).get_production_company(),1);


           }

        }

return m;

    }
*/

}





