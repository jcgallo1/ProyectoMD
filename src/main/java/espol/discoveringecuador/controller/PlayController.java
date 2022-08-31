package espol.discoveringecuador.controller;

import espol.discoveringecuador.App;
import espol.discoveringecuador.model.*;
import espol.discoveringecuador.model.util.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

import static java.lang.Thread.sleep;

public class PlayController implements Initializable {

    @FXML private Button button_spin;
    @FXML private Button button_true;
    @FXML private Button button_false;
    @FXML private Button button_end;
    @FXML private TextField textField_points;
    @FXML private TextField textField_tries;
    @FXML private Label label_question;
    @FXML private Label label_food;
    @FXML private Label label_x;
    @FXML private ImageView imageView_ruleta;
    @FXML private ImageView imageView_pingu;
    private Double rotation = 100.0;
    private Country Ecuador;
    private ArrayList<Region> regions = new ArrayList<>();
    private ArrayList<Province> provinces = new ArrayList<>();
    private ArrayList<Food> foods = new ArrayList<>();
    private Region currentRegion;
    private Province currentProvince;
    private Integer costaIndex = 0;
    private Integer insultarIndex = 1;
    private Integer orienteIndex = 2;
    private Integer sierraIndex = 3;

    private Integer currentPoints = 0;
    private Integer currentTries = 0;

    private Game game;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        textField_points.setEditable(false);
        textField_tries.setEditable(false);
        Ecuador = InitEcuador.getEcuador();
        regions = Ecuador.getRegionList();
        label_food.setWrapText(true);
        label_question.setWrapText(true);
        label_x.setWrapText(true);

        imageView_pingu.setVisible(false);
        imageView_ruleta.setVisible(false);
        textField_tries.setText(String.valueOf(currentTries));
        textField_points.setText(String.valueOf(currentPoints));
        textField_tries.setEditable(false);
        textField_points.setEditable(false);


    }

    private void fillProvinces() {
        for (Province province : provinces) {
            if (foods.isEmpty()) {
                foods = province.getFoodList();
            } else {
                foods.addAll(province.getFoodList());
            }
        }
    }
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @FXML
    protected void play() {
//        imageView_ruleta.setRotate(current);
//        current+= 30.0;
        game.setCountry(Ecuador);
        rotate();
        generateQuestion();

    }

    public void generateQuestion() {
        String question = getQuestionBasedOnMode(game.getMode());
        foods.clear();
        for (Province province : provinces) {
            foods.addAll(province.getFoodList());
        }

        if (game.getMode() == 'R') {
            imageView_ruleta.setVisible(false);
            imageView_pingu.setVisible(true);
            label_food.setText(getRandomFood().getName());
            label_question.setText(question);
            label_x.setText(getRandomRegion().getName());
            System.out.println(">> Current Region: " + currentRegion.getName());
            for (Food food: foods) {
                System.out.println(food);
            }
        } else {
            imageView_ruleta.setVisible(true);
            imageView_pingu.setVisible(false);

            Integer randomIndexProvince = provinces.indexOf(getRandomProvince());
            currentProvince = provinces.get(randomIndexProvince);
            label_food.setText(getRandomFood().getName());
            label_question.setText(question);
            label_x.setText(getRandomProvince().getName());
            System.out.println(">> Current Province: " + currentProvince.getName());
            for (Food food: foods) {
                System.out.println(food);
            }
        }
    }


    @FXML
    protected void endGame() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>END GAME");
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Perdio el juego :c");
        a.show();
        resetGame();
    }
    private void addTries() {
        currentTries++;
        textField_tries.setText(String.valueOf(currentTries));
    }

    private void addPoints() {
        currentPoints++;
        textField_points.setText(String.valueOf(currentPoints));
    }

    private void restPoints() {
        if (currentPoints == 0) {
            endGame();
        } else {
            currentPoints--;
            textField_points.setText(String.valueOf(currentPoints));
        }
    }
    @FXML
    protected void answerTrue() {
        addTries();
        System.out.println("Answer TRUE");
        if (game.getMode() == 'R') {
            String region_answered = label_x.getText();
            if (currentRegion.getName().equals(region_answered)) {
                addPoints();
                System.out.println("ADD POINTS");
            }
            else {
                restPoints();
                System.out.println("REST POINTS");
            }
        } else {
            String province_answered = label_x.getText();
            if (currentProvince.getName().equals(province_answered)) {
                addPoints();
                System.out.println("ADD POINTS");
            }
            else {
                restPoints();
                System.out.println("REST POINTS");
            }
        }
        checkWin();
        play();
    }
    @FXML
    protected void answerFalse() {
        addTries();
        System.out.println("Answer FALSE");
        if (game.getMode() == 'R') {
            String region_answered = label_x.getText();
            if (!currentRegion.getName().equals(region_answered)) {
                addPoints();
                System.out.println("ADD POINTS");
            }
            else {
                restPoints();
                System.out.println("REST POINTS");
            }
        } else {
            String province_answered = label_x.getText();
            if (!currentProvince.getName().equals(province_answered)) {
                addPoints();
                System.out.println("ADD POINTS");
            }
            else {
                restPoints();
                System.out.println("REST POINTS");
            }
        }
        checkWin();
        play();
    }

    private void checkWin() {
        if (currentTries == 10) {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "El juego ha terminado, sus puntos son: " + currentPoints.toString());
            a.show();
            resetGame();
        }
    }

    private void resetGame() {
        final Integer height = 700;
        final Integer width = height - 200;
        try {
            FXMLLoader fxml = App.loadFXMLLoad("welcomeView");
            App.switchWindowGame(fxml, height, width);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    private Province getRandomProvince() {
        Integer random = (int) (Math.random() * provinces.size());
        return provinces.get(random);
    }
    private Region getRandomRegion() {
        Integer random = (int) (Math.random() * regions.size());
        return regions.get(random);
    }

    private Food getRandomFood() {
        Integer random = (int) (Math.random() * foods.size());
        return foods.get(random);
    }

    public String getQuestionBasedOnMode(Character mode) {
        String str = "Este platillo pertenece a la ";
        return str + (mode == 'P' ? "Provincia de: ":"Región de: ");
    }

    private void rotate() {
        int vueltas = 0;
        while (true) {
            imageView_ruleta.setRotate(rotation);
            rotation += 60;
            if (rotation > 400) {
                rotation = 40.0;
            }
            vueltas++;
            if (vueltas == 20) {
                vueltas = (int) (Math.random() * 400);
                if (vueltas <= 40) {
                    currentRegion = regions.get(2);
                    provinces = currentRegion.getProvincesList();
                    imageView_ruleta.setRotate(40);
                    break;
                }
                if (vueltas <= 100) {
                    currentRegion = regions.get(0);
                    provinces = currentRegion.getProvincesList();
                    rotation = 100.0;
                    imageView_ruleta.setRotate(rotation);
                    break;
                }
                if (vueltas > 100 && vueltas <= 160) {
                    currentRegion = regions.get(3);
                    provinces = currentRegion.getProvincesList();
                    rotation = 160.0;
                    imageView_ruleta.setRotate(rotation);
                    break;
                }
                if (vueltas > 160 && vueltas <= 220) {
                    currentRegion = regions.get(0);
                    provinces = currentRegion.getProvincesList();
                    rotation = 220.0;
                    imageView_ruleta.setRotate(rotation);
                    break;
                }
                if (vueltas > 220 && vueltas <= 280) {
                    currentRegion = regions.get(2);
                    provinces = currentRegion.getProvincesList();
                    rotation = 280.0;
                    imageView_ruleta.setRotate(rotation);
                    break;
                }
                if (vueltas > 280) {
                    currentRegion = regions.get(1);
                    provinces = currentRegion.getProvincesList();
                    rotation = 340.0;
                    imageView_ruleta.setRotate(rotation);
                    break;
                }
                break;
            }
        }
    }
}