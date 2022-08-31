module espol.discoveringecuador {
    requires javafx.controls;
    requires javafx.fxml;
    requires jackson.all;


    opens espol.discoveringecuador to javafx.fxml;

    exports espol.discoveringecuador to javafx.graphics;
    exports espol.discoveringecuador.model;
    exports espol.discoveringecuador.controller;
    opens espol.discoveringecuador.controller to javafx.fxml;
}