package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class searchbyyear {
    private Stage stage;
    private Scene scene;

    @FXML
    TextField YearValue;
    @FXML
    private ListView<String> listview;
    List<Movie>  printMovies=new ArrayList();

    public void Search(List<Movie> movielist,String username)
    {

        int index;

        for (int i = 0; i < movielist.size(); i++) {
            Movie m = movielist.get(i);
            if (m.get_release_year() ==Integer.parseInt(username)) {
                index=i;
                printMovies.add(movielist.get(i));


            }


        }
        int i;
        for(i=0;i<printMovies.size();i++)
        {
            listview.getItems().add(printMovies.get(i).movie_print());


        }

    }


    public void onMainMenuButtonClick(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("movieSearch.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 440, Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }
}
