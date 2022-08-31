package espol.discoveringecuador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {


    private static Scene scene;
    private static Stage stage;
    private static Integer width = 477;
    private static Integer height = 400;
    private static String welcomeView = "welcomeView.fxml";
    private static String title = "Discovering Ecuador GAME!";
    private static boolean resizable = false;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(welcomeView));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        this.stage = stage;
        this.stage.setTitle(title);
        this.stage.setScene(scene);
        this.stage.setResizable(resizable);
        this.stage.show();
    }

    public static void switchWindowGame(FXMLLoader fxml, double height, double width) throws IOException {
        scene = new Scene(fxml.load(), height, width);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        return (new FXMLLoader(App.class.getResource(fxml + ".fxml"))).load();
    }
    public static FXMLLoader loadFXMLLoad(String fxml) throws IOException {
        return (new FXMLLoader(App.class.getResource(fxml + ".fxml")));
    }
    public static void main(String[] args) {
        launch();
    }
}