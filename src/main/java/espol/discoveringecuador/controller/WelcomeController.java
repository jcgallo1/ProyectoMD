package espol.discoveringecuador.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import espol.discoveringecuador.model.Game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {

    @FXML private RadioButton radioButton_gameMode_provincias;
    @FXML private RadioButton radioButton_gameMode_regiones;
    @FXML private Button button_play;
    private Game game;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        game = new Game();
    }

    @FXML
    public void play() throws IOException {
        App.setRoot("playView");
    }
    @FXML
    protected void setRegion() {
        if (!radioButton_gameMode_regiones.isSelected()) { radioButton_gameMode_regiones.setSelected(true); radioButton_gameMode_provincias.setSelected(false); }
        else if (radioButton_gameMode_provincias.isSelected()) { radioButton_gameMode_provincias.setSelected(false); radioButton_gameMode_regiones.setSelected(true); }
        game.setMode('R');
    }
    @FXML
    protected void setProvince() {
        if (!radioButton_gameMode_provincias.isSelected()) { radioButton_gameMode_provincias.setSelected(true); radioButton_gameMode_regiones.setSelected(false); }
        else if (radioButton_gameMode_regiones.isSelected()) { radioButton_gameMode_regiones.setSelected(false); radioButton_gameMode_provincias.setSelected(true); }
        game.setMode('P');
    }
//    @FXML
//    protected void setMode() {
//        if (modeCheckBox.isSelected()) { mode2RadioButton.setVisible(true); }
//        else {
//            mode2RadioButton.setVisible(false);
//            mode2RadioButton.setSelected(false);
//        }
//    }


}