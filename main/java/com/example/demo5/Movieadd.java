package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Movieadd {
    public TextField movieTitle = null;
    public TextField releaseYear;
    public TextField budget = null;
    public TextField runTime = null;
    public TextField revenue = null;
    public TextField genreFirst = null;
    public TextField genreSecond = null;
    public TextField genreThird = null;
    public Label movieaddedsignal;
    private Stage stage;
    private Scene scene;
    private Parent root;

   public static FXMLLoader loader;

   static void setLoader(FXMLLoader loade)
   {
     loader=loade;
   }
    public void onaddmoviebuttonclick(ActionEvent actionEvent) {

        String movietitle = movieTitle.getText();

        int releaseyear = Integer.parseInt(releaseYear.getText());//must input taken

        int budGet = Integer.parseInt(budget.getText());//must input taken
        int runtime = Integer.parseInt(runTime.getText());//must input taken
        int reVenue = Integer.parseInt(revenue.getText());
        String genrefirst = genreFirst.getText();
        String genresecond = genreSecond.getText();
        String genresthird = genreThird.getText();
        String maingenre=genrefirst+","+genresecond+","+genresthird;

        Movie addMovie = new Movie(movietitle, releaseyear, maingenre, runtime, ProductionCompanyInterface.productioncompanyname, budGet, reVenue);

        try {
            Client.socketWrapper.write(addMovie);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        movieaddedsignal.setText("One Movie Added");



    }

    public void onBackmenuClick(ActionEvent actionEvent) throws Exception{



        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1=Searchbyproduction.scene;
        stage.setScene(scene1);
        stage.show();



    }
}
