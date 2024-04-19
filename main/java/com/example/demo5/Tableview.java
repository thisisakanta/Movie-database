package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class Tableview {
    public static int ind=0;
    @FXML
    TableView<Movie> tablelist;

    @FXML
 TableColumn<Movie, String> MovieName;

    @FXML
    TableColumn<Movie, String> Genre;

    @FXML
   TableColumn<Movie, Integer> ReleaseYear;
    @FXML
    TableColumn<Movie, Integer> Runtime;
    @FXML
   TableColumn<Movie, String> productionCom;
    @FXML
     TableColumn<Movie, Integer> Budget;
    @FXML
     TableColumn<Movie, Integer> Revenue;

    private Stage stage;

    private Parent root;

    public String username;

    @FXML
    public  void initialize() {
        ind=1;
        MovieName.setCellValueFactory(new PropertyValueFactory<Movie,String>("_movie_title"));
        ReleaseYear.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("_release_year"));
        Runtime.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("_runtime"));
        Revenue.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("_revenue"));
        productionCom.setCellValueFactory(new PropertyValueFactory<Movie, String>("_production_company"));
       Genre.setCellValueFactory(new PropertyValueFactory<Movie, String>("_genre"));
       Budget.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("_budget"));
        if(ProductionCompanyInterface.flag==3)
            show(Client.ob2);
        else if(ProductionCompanyInterface.flag==2)
        {
            MENU2 ob = new MENU2();
            List<Movie> Movies = ob.input1(Client.ob2);
            show(Movies);

        }
        else if(ProductionCompanyInterface.flag==1)
        {  MENU2 ob = new MENU2();
            List<Movie> Movies = ob.input2(Client.ob2);
            show(Movies);

        }


    }


    public void show(List<Movie> Movies) {

        tablelist.getItems().clear();
        int i=0;
        for (i = 0; i < Movies.size(); i++) {
            tablelist.getItems().add(Movies.get(i));
        }



    }


    public void onBackMenuClick(ActionEvent actionEvent)throws Exception {
        ind=0;
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene1=Searchbyproduction.scene;
        stage.setScene(scene1);
        stage.show();




    }

    public  void onRefreshbuttonclick(ActionEvent actionEvent)throws Exception {

        if(ProductionCompanyInterface.flag==3)
        show(Client.ob2);
        else if(ProductionCompanyInterface.flag==2)
        {
            MENU2 ob = new MENU2();
            List<Movie> Movies = ob.input1(Client.ob2);
            show(Movies);

        }
        else if(ProductionCompanyInterface.flag==1)
        {  MENU2 ob = new MENU2();
            List<Movie> Movies = ob.input2(Client.ob2);
            show(Movies);

        }







    }











}


