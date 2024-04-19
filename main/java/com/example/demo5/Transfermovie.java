package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Transfermovie {


    public TextField transferProductionCompany;
    public TextField transferMovieName;
    public String transfermovieName;
    public String transferproductionName;
    public Label textToseen;
    private Stage stage;

    private Parent root;

    public String username;

    public void onTransferbuttonclick(ActionEvent actionEvent) throws Exception{
        transfermovieName=transferMovieName.getText();
        transferproductionName=transferProductionCompany.getText();

        String s=transfermovieName+"/"+transferproductionName+"/"+ProductionCompanyInterface.productioncompanyname;
        try {
            Client.socketWrapper.write(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

if(Server.flagfound==0)
{
    Alert alert=new Alert(Alert.AlertType.ERROR);
    alert.showAndWait();

}



else {


    textToseen.setText("One Movie Has been TRANSFERRED");

}


    }


    public void onBackmenuoptionclick(ActionEvent actionEvent)throws Exception {


            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene1=Searchbyproduction.scene;
            stage.setScene(scene1);
            stage.show();





    }
}
