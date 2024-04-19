package com.example.demo5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server extends Thread {


    private static final String INPUT_FILE_NAME = "movies.txt";

    public static HashMap<String,SocketWrapper> clientMap= new HashMap<>();
    public static String clientName;//for threading to connect with the server.
    public static List<Movie> Movielist = new ArrayList();
    public  static int  flagfound=0;
    public static void main(String args[]) throws IOException {


        BufferedReader file = new BufferedReader(new FileReader(INPUT_FILE_NAME));

        while (true) {
            String line = null;
            try {
                line = file.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (line == null) {
                break;
            }
            String[] part = line.split(",");
            String p = part[2] + "," + part[3] + "," + part[4];
            int i = Integer.parseInt(part[7]);
            int j = Integer.parseInt(part[8]);
            int d = Integer.parseInt(part[5]);
            int year = Integer.parseInt(part[1]);


            Movie k = new Movie(part[0], year, p, d, part[6], i, j);
            Movielist.add(k);


        }

        try {
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ServerSocket serverSocket = new ServerSocket(33433);


        while (true) {

            Socket clientSocket = serverSocket.accept();
            SocketWrapper socketWrapper = new SocketWrapper(clientSocket);
            new Thread(() -> {
                try {

                    while (true) {


                        Object data = socketWrapper.read();
                        if (data instanceof String) {

                         String si = (String) data;
                         String[] part = si.split("/");




                            if (part.length == 1) {
                                clientName = (String) data;
                                clientMap.put(clientName.toUpperCase(),socketWrapper);

                                List<Movie> clientmoviename = new ArrayList<>();
                                for (int i = 0; i < Movielist.size(); i++) {
                                    if (clientName.equalsIgnoreCase(Movielist.get(i).get_production_company())) {
                                        clientmoviename.add(Movielist.get(i));

                                    }


                                }
                                clientMap.get(clientName.toUpperCase()).write(clientmoviename);


                            } else if(part.length==3){
                               String movietitle=part[0];
                               String newpro=part[1];
                               String prepro=part[2];

                               for(int i=0;i<Movielist.size();i++)
                               {

                                   if(movietitle.equalsIgnoreCase(Movielist.get(i).get_movie_title()))
                                   {
                                       Movielist.get(i).set_production_company(newpro);
                                       flagfound=1;
                                       System.out.println(Movielist.get(i).movie_print());
                                       break;
                                   }



                               }
                               if(flagfound==0)
                                   break;


                                int p = 0;
                                BufferedWriter writ = new BufferedWriter(new FileWriter(INPUT_FILE_NAME));
                                for (p = 0; p < Movielist.size(); p++) {
                                    Movie k = Movielist.get(p);
                                    String[] s = new String[2000];
                                    s[0] = k.get_movie_title();
                                    s[1] = Integer.toString(k.get_release_year());
                                    s[2] = k.get_genre();
                                    s[3] = Integer.toString(k.get_runtime());
                                    s[4] = k.get_production_company();
                                    s[5] = Integer.toString(k.get_budget());
                                    s[6] = Integer.toString(k.get_revenue());
                                    String s_again = s[0] + "," + s[1] + "," + s[2] + "," + s[3] + "," + s[4] + "," + s[5] + "," + s[6];
                                    writ.write(s_again);

                                    writ.write(System.lineSeparator());
                                }
                                writ.close();
                               List<Movie> clientmoviename = new ArrayList<>();
                                for (int i = 0; i <Movielist.size(); i++) {
                                    if (prepro.equalsIgnoreCase(Movielist.get(i).get_production_company())) {
                                        clientmoviename.add(Movielist.get(i));


                                    }


                                }
                                List<Movie> clientmoviename2 = new ArrayList<>();
                                for (int i = 0; i < Movielist.size(); i++) {
                                    if (newpro.equalsIgnoreCase(Movielist.get(i).get_production_company())) {
                                        clientmoviename2.add(Movielist.get(i));


                                    }


                                }
                                for (int i = 0; i <clientmoviename.size() ; i++) {
                                    System.out.println(clientmoviename.get(i).movie_print());
                                }
                                System.out.println("/////////////////////");
                                for (int i = 0; i <clientmoviename2.size() ; i++) {
                                    System.out.println(clientmoviename2.get(i).movie_print());
                                }

                                List<Movie> list2=new ArrayList<>(clientmoviename);

                                clientMap.get(prepro.toUpperCase()).write(list2);

                                List<Movie> list3=new ArrayList<>(clientmoviename2);

                                clientMap.get(newpro.toUpperCase()).write(list3);






                            }



                        }











                        if (data instanceof Movie) {

                            Movielist.add((Movie) data);

                            for (int i = 0; i < Movielist.size(); i++) {
                                System.out.println(Movielist.get(i).movie_print());

                            }



                            int p = 0;
                            BufferedWriter writ = new BufferedWriter(new FileWriter(INPUT_FILE_NAME));
                            for (p = 0; p < Movielist.size(); p++) {
                                Movie k = Movielist.get(p);
                                String[] s = new String[2000];
                                s[0] = k.get_movie_title();
                                s[1] = Integer.toString(k.get_release_year());
                                s[2] = k.get_genre();
                                s[3] = Integer.toString(k.get_runtime());
                                s[4] = k.get_production_company();
                                s[5] = Integer.toString(k.get_budget());
                                s[6] = Integer.toString(k.get_revenue());
                                String s_again = s[0] + "," + s[1] + "," + s[2] + "," + s[3] + "," + s[4] + "," + s[5] + "," + s[6];
                                writ.write(s_again);

                                writ.write(System.lineSeparator());
                            }
                            writ.close();

                            List<Movie> clientmoviename = new ArrayList<>();
                            for (int i = 0; i < Movielist.size(); i++) {
                                if (clientName.equalsIgnoreCase(Movielist.get(i).get_production_company())) {
                                    clientmoviename.add(Movielist.get(i));

                                }
                            }
                            for(Movie m:clientmoviename)
                            {
                                System.out.println(m.get_movie_title());
                            }
                            clientMap.get(clientName.toUpperCase()).write(clientmoviename);
                        }


                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);

                } finally {
                    try {
                        clientMap.get(clientName.toUpperCase()).closeConnection();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }).start();


        }

    }


}

