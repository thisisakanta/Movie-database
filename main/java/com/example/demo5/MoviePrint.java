package com.example.demo5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MoviePrint {
    @FXML
    Label movieprint;
    public void display(String username)
    {
        movieprint.setText(username);
    }


}
