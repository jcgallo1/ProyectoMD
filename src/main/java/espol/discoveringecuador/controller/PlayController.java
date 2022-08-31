package espol.discoveringecuador.controller;

import espol.discoveringecuador.model.Game;
import espol.discoveringecuador.model.util.InitEcuador;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayController implements Initializable {

    @FXML private Button button_spin;
    @FXML private Button button_true;
    @FXML private Button button_false;
    @FXML private Button button_end;
    @FXML private TextField textField_points;
    @FXML private TextField textField_tries;
    @FXML private Label label_question;
    @FXML private ImageView imageView_ruleta;


    private Game game;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        textField_points.setEditable(false);
        textField_tries.setEditable(false);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @FXML
    protected void play() {

        System.out.println(game.toString());
    }
}