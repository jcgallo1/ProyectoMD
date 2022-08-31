package espol.discoveringecuador.model.util;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

import static java.lang.Thread.sleep;

public class Rotation implements Runnable {

    private ImageView img;
    private Double rote = 65.0;
    public Rotation(ImageView img) {
        this.img = img;
        this.rote=rote;
    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            rote+=13;

                this.img.setRotate(rote);
                try {
                    sleep(133);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


        }

    }



}
