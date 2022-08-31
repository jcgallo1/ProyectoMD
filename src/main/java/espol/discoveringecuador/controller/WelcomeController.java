package espol.discoveringecuador.controller;

import espol.discoveringecuador.App;
import espol.discoveringecuador.model.util.InitEcuador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    private final String errorMessage = "Debe seleccionar un modo de juego";
    private final Integer height = 700;
    private final Integer width = height - 200;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    @FXML
    public void play() {

        try {
            if (!validateSelectedMode()) {
                FXMLLoader fxml = App.loadFXMLLoad("playView");
                App.switchWindowGame(fxml, height, width);
                PlayController pc = fxml.getController();
                Game game = new Game();
                game.setMode(getMode());
                pc.setGame(game);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, errorMessage);
                a.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    @FXML
    protected void setRegion() {
        if (!radioButton_gameMode_regiones.isSelected()) {
            radioButton_gameMode_regiones.setSelected(true);
            radioButton_gameMode_provincias.setSelected(false);
        } else if (radioButton_gameMode_provincias.isSelected()) {
            radioButton_gameMode_provincias.setSelected(false);
            radioButton_gameMode_regiones.setSelected(true);
        }
    }
    @FXML
    protected void setProvince() {
        if (!radioButton_gameMode_provincias.isSelected()) {
            radioButton_gameMode_provincias.setSelected(true);
            radioButton_gameMode_regiones.setSelected(false);
        } else if (radioButton_gameMode_regiones.isSelected()) {
            radioButton_gameMode_regiones.setSelected(false);
            radioButton_gameMode_provincias.setSelected(true);
        }
    }

    private boolean validateSelectedMode() {
        return !radioButton_gameMode_regiones.isSelected() && !radioButton_gameMode_provincias.isSelected();
    }

    private Character getMode() {
        if (radioButton_gameMode_regiones.isSelected()) return 'R';
        else if (radioButton_gameMode_provincias.isSelected()) return 'P';
        else return 'x';
    }


}