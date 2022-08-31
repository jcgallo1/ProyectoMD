package espol.discoveringecuador.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayController implements Initializable {


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }
    @FXML
    public void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}