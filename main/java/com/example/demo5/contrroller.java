package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class contrroller {

    @FXML
    public TextField year;
    @FXML
    public TextField genreName;
    @FXML
    public TextField productionCompanyName;
    @FXML
    TextField MoveiName;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public static List<Movie> Movielist = new ArrayList();
    public String username;


    private static final String INPUT_FILE_NAME = "movies.txt";


    public static void MovieList() {

        //private static final String OUTPUT_FILE_NAME = "out.txt";


        //array name
        BufferedReader file;

        {
            try {
                file = new BufferedReader(new FileReader(INPUT_FILE_NAME));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


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
    }


    public void toSearchMoviesButton(ActionEvent actionEvent) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("movieSearch.fxml"));
        stage =(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 440, Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }

    public void onSearch(ActionEvent actionEvent) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MovieTitle.fxml"));
        stage =(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 440, Color.BLACK);
        stage.setScene(scene);
        stage.show();

    }

    public void OnSearchButtonClick(ActionEvent actionEvent) throws Exception {
        String username = MoveiName.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("moveiPrint.fxml"));
        root = loader.load();
        MovieList();
        int index = -1;
        for (int i = 0; i < Movielist.size(); i++) {
            Movie m = Movielist.get(i);
            if (m.get_movie_title().toUpperCase().equals(username.toUpperCase())) {

                index = i;
                break;
            }
        }

        String MovieName = Movielist.get(index).movie_print();
        MoviePrint movie = loader.getController();
        movie.display(MovieName);


        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);

        stage.setScene(scene1);

        stage.show();

    }

    public void onSearchByYearButton(ActionEvent actionEvent) throws Exception {
        username = year.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchByyear.fxml"));
        root = loader.load();
        MovieList();
        searchbyyear year = loader.getController();
        year.Search(Movielist, username);


        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();


    }

    public void ONYEARSETUP(ActionEvent actionEvent) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("yearsetup.fxml"));
        stage =(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 440, Color.BLACK);
        stage.setScene(scene);
        stage.show();


    }

    public void onGenreButton(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("genre.fxml"));
        stage =(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 440, Color.BLACK);
        stage.setScene(scene);
        stage.show();


    }

    public void ongenre(ActionEvent actionEvent) throws Exception {
        username = genreName.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listviewofgenre.fxml"));
        root = loader.load();
        MovieList();
        Listviewofgenre genre = loader.getController();
        genre.search(Movielist, username);


        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();

    }

    public void onProductionClick(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("production.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 440, Color.BLACK);
        stage.setScene(scene);
        stage.show();

    }

    public void onProductionBasedMovieClick(ActionEvent actionEvent) throws Exception {
        username = productionCompanyName.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listviewofProduction.fxml"));
        root = loader.load();
        MovieList();
        ListviewofProduction production = loader.getController();
        production.search(Movielist, username);


        stage =(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();


    }

    public void OnTop10moveiButton(ActionEvent actionEvent) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("top10movies.fxml"));
        root = loader.load();
        MovieList();
        Top10movies showMovies = loader.getController();
        showMovies.show(Movielist);


        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();


    }


    public void onSearchProductionClick(ActionEvent actionEvent) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("productionCompanyLogin.fxml"));
        root = fxmlLoader.load();
        stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onaddmoviebuttonclick(ActionEvent actionEvent) throws Exception{


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("movieadd.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 600, 440, Color.BLACK);
        stage.setScene(scene);

        stage.show();





    }
}







