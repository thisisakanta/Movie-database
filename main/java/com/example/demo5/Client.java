package com.example.demo5;


import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static List<Movie> ob2 = new ArrayList<>();
    public static Movie movie;
    public static Object data;

    public static SocketWrapper socketWrapper = null;
//    static{
//        try {
////            socketWrapper = new SocketWrapper("127.0.0.1", 34433);
//        }catch(Exception e){}
//    }


    public Client(Object username) {

        data=username;
        try {
            socketWrapper = new SocketWrapper("127.0.0.1", 33433);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        new Thread(() -> {
            try {

                socketWrapper.write(data);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        ).start();

            new Thread(() ->
            {
                while (true) {
                    try {


                        Object data = socketWrapper.read();
                        ob2 = (List<Movie>) data;

                        for (int i = 0; i <ob2.size() ; i++) {
                            System.out.println(ob2.get(i).movie_print());
                        }
                        if(Tableview.ind==1)
                        {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Parent root= null;
                                    try {
                                        root = FXMLLoader.load(getClass().getResource("tableview.fxml"));
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    Scene scene1=new Scene(root);
                                    ProductionCompanyInterface.test_stage.setScene(scene1);
                                    ProductionCompanyInterface.test_stage.show();

                                }
                            });

                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }


            }).start();
        }


    }



