package com.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Searchbyproduction {

    @FXML
    public TextField productionComapnyName;
    public TextField productionname;
    @FXML
    public  ImageView loginImage;

    private Stage stage;
public static Scene scene;
    private Parent root;

    public String username;
public FXMLLoader loader;

void setLoginImage(Image image)
{
    loginImage.setImage(image);
}

    public void onproductioncompanylogin(ActionEvent actionEvent) throws Exception {
        username = productionname.getText();
        loader = new FXMLLoader(getClass().getResource("productionface.fxml"));

        root = loader.load();
        Client obj = new Client(username);

        ProductionCompanyInterface ob = loader.getController();
        //for(int i=0;i<Client.ob2.size();i++)
          //  System.out.println(Client.ob2.get(i).movie_print());



        ob.labelling.setText(username);
        ob.setProductionMovie(Client.ob2);
        ob.setProductioncompanyname(username);
        Movieadd.setLoader(loader);
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


}