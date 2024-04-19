package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ProductionCompanyInterface {

    public Label labelling;
    public static String productioncompanyname;
    public static List<Movie> movielistOfProduction = new ArrayList<>();
    private Stage stage;

    private Parent root;
   public static  FXMLLoader loader2;
public static int flag;
public static Stage test_stage;

    public void setProductionMovie(List<Movie> ob2) {

        movielistOfProduction = ob2;
    }

    public void setProductioncompanyname(String username) {
        productioncompanyname = username;
    }


    public void onMaximumrevenuesearchbuttonclick(ActionEvent actionEvent) throws Exception {


        loader2 = new FXMLLoader(getClass().getResource("tableview.fxml"));
        root = loader2.load();

        MENU2 ob = new MENU2();


        List<Movie> Movies = ob.input2(Client.ob2);
        //for (int j = 0; j <Movies.size() ; j++) {
        //      System.out.println (Movies.get(i).movie_print());
        // }
        for (int i = 0; i < Client.ob2.size(); i++) {
            System.out.println(Client.ob2.get(i).movie_print());
        }


        Tableview ob2 = loader2.getController();
        flag=1;

        ob2.show(Movies);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);

        stage.setScene(scene1);
        stage.show();

    }


    public void onMostRecentMoviesButtonClick(ActionEvent actionEvent) throws Exception {


     loader2 = new FXMLLoader(getClass().getResource("tableview.fxml"));
        root = loader2.load();
        contrroller.MovieList();

       /* for(int i=0;i<movielistOfProduction.size();i++)
            System.out.println(movielistOfProduction.get(i).movie_print());*/
        MENU2 ob = new MENU2();
        List<Movie> Movies = ob.input1(Client.ob2);


        Tableview listmovie = loader2.getController();
        listmovie.show(Movies);
        flag=2;

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();

    }

    public void onAddMovieButtonClick(ActionEvent actionEvent) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("movieadd.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();


    }

    public void onTransferbuttonclick(ActionEvent actionEvent)throws Exception {


       FXMLLoader loader = new FXMLLoader(getClass().getResource("transfermovie.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();






    }

    public void onMovieListButtonClick(ActionEvent actionEvent)throws Exception {

     FXMLLoader loader = new FXMLLoader(getClass().getResource("tableview.fxml"));
        root = loader.load();

        flag=3;
        Tableview listmovie = loader.getController();
        listmovie.show(Client.ob2);

        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);
        test_stage=stage;
        stage.setScene(scene1);
        stage.show();




    }
}
