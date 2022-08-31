package espol.discoveringecuador.controller;//package controller;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.ResourceBundle;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.image.ImageView;
//
//public class tmp implements Initializable {
//
//    int count = 0;
//    @FXML
//    private ImageView ruleta;
//    @FXML
//    private ImageView ruleta_circulo;
//    @FXML
//    private Button btn_Girar;
//
//    public int rotacion = 100;
//
//    public regiones_enum region;
//    @FXML
//    private Label pregunta;
//    @FXML
//    private Button btn_true;
//    @FXML
//    private Button btn_false;
//    @FXML
//    private Label puntos;
//
//    public int punt;
//
//    public Regiones reg_conjunto;
//
//    public Map<String, String> comidasporRegion;
//
//    public String comida;
//    int num_preguntasMax=10;
//    int[][] matrizRespuestas;
//    @FXML
//    private Label respuesta;
//    @FXML
//    private Label lbl_num;
//    @FXML
//    private Button regresar;
//
//
//    @Override
//    public void initialize(URL arg0, ResourceBundle arg1) {
//
//        this.btn_false.setVisible(false);
//        this.btn_true.setVisible(false);
//        this.regresar.setVisible(false);
//        reg_conjunto = new Regiones();
//        this.puntos.setText("10");
//        punt = 0;
//        reg_conjunto.addRegiones("COSTA"); //0
//        reg_conjunto.addRegiones("SIERRA"); //1
//        reg_conjunto.addRegiones("ORIENTE"); //2
//        reg_conjunto.addRegiones("GALAPAGOS");//3
//
//        reg_conjunto.addComidas("Encebollado");
//        reg_conjunto.addComidas("Ceviches");
//        reg_conjunto.addComidas("Corviche");
//        reg_conjunto.addComidas("Bolón de verde");
//        reg_conjunto.addComidas("Caldo de salchicha");
//        reg_conjunto.addComidas("Encocado");
//
//        reg_conjunto.addComidas("Locro de Papas");
//        reg_conjunto.addComidas("Fritada");
//        reg_conjunto.addComidas("Humitas");
//        reg_conjunto.addComidas("Llapingachos");
//        reg_conjunto.addComidas("Mote Pillo");
//        reg_conjunto.addComidas("Fanesca");
//
//        reg_conjunto.addComidas("Ayampaco");
//        reg_conjunto.addComidas("Maito de pescado");
//        reg_conjunto.addComidas("Uchumanka");
//        reg_conjunto.addComidas("Casabe de Yuca");
//        reg_conjunto.addComidas("Caldo de Corroncho");
//        reg_conjunto.addComidas("Mote Pillo");
//
//        reg_conjunto.addComidas("Arroz marinero");
//        reg_conjunto.addComidas("Bacalao con papas");
//        reg_conjunto.addComidas("Ceviche de canchalagua");
//        reg_conjunto.addComidas("Mariscos");
//        reg_conjunto.addComidas("Pan de yuca");
//        reg_conjunto.addComidas("Sopa marinera");
//
//        //MAp key comida valor region;
//        comidasporRegion = new HashMap();
//        comidasporRegion.put("Encebollado", "COSTA,0,0");
//        comidasporRegion.put("Ceviches", "COSTA,1,0");
//        comidasporRegion.put("Corviche", "COSTA,2,0");
//        comidasporRegion.put("Bolón de verde", "COSTA,3,0");
//        comidasporRegion.put("Caldo de salchicha", "COSTA,4,0");
//        comidasporRegion.put("Encocado", "COSTA,5,1");
//
//        comidasporRegion.put("Locro de Papas", "SIERRA,6,1");
//        comidasporRegion.put("Fritada", "SIERRA,7,1");
//        comidasporRegion.put("Humitas", "SIERRA,8,1");
//        comidasporRegion.put("Llapingachos", "SIERRA,9,1");
//        comidasporRegion.put("Fanesca", "SIERRA,10,1");
//        comidasporRegion.put("Mote Pillo", "SIERRA,11,1");
//
//        comidasporRegion.put("Ayampaco", "ORIENTE,12,2");
//        comidasporRegion.put("Maito de pescado", "ORIENTE,13,2");
//        comidasporRegion.put("Uchumanka", "ORIENTE,14,2");
//        comidasporRegion.put("Casabe de Yuca", "ORIENTE,15,2");
//        comidasporRegion.put("Caldo de Corroncho", "ORIENTE,16,2");
//        comidasporRegion.put("Mote Pillo", "ORIENTE,17,2");
//
//        comidasporRegion.put("Arroz marinero", "GALAPAGOS,18,3");
//        comidasporRegion.put("Bacalao con papas", "GALAPAGOS,19,3");
//        comidasporRegion.put("Ceviche de canchalagua", "GALAPAGOS,20,3");
//        comidasporRegion.put("Mariscos", "GALAPAGOS,21,3");
//        comidasporRegion.put("Pan de yuca", "GALAPAGOS,22,3");
//        comidasporRegion.put("Sopa marinera", "GALAPAGOS,23,3");
//
//        matrizRespuestas=new int[reg_conjunto.getRegiones().size()][reg_conjunto.getComidas().size()];
//        //LLENAMOS LA MATRIZ DE 0;
//        for (int i = 0; i < reg_conjunto.getRegiones().size(); i++) {
//            for (int j = 0; j < reg_conjunto.getComidas().size(); j++) {
//                matrizRespuestas[i][j] = 0;
//            }
//
//        }
//    }
//
//    @FXML
//    public void play() throws IOException {
//        App.setRoot("secondary");
//    }
//
//
//    public void agregarRespuesta(int fila, int colummna){
//        for (int i = 0; i < reg_conjunto.getRegiones().size(); i++) {
//            for (int j = 0; j < reg_conjunto.getComidas().size(); j++) {
//                if (fila==i && colummna==j) {
//                    matrizRespuestas[i][j] ++;
//                }
//            }
//
//        }
//    }
//
//    public void calcularPuntaje(){
//        int suma=0;
//        this.btn_false.setVisible(false);
//        this.btn_true.setVisible(false);
//        this.pregunta.setVisible(false);
//        this.respuesta.setVisible(false);
//        for (int i = 0; i < reg_conjunto.getRegiones().size(); i++) {
//            for (int j = 0; j < reg_conjunto.getComidas().size(); j++) {
//                suma+=matrizRespuestas[i][j];
//            }
//        }
//        this.lbl_num.setText("Puntaje:");
//        this.puntos.setText(String.valueOf(suma));
//        this.regresar.setVisible(true);
//    }
//
//
//    @FXML
//    public void Rotate() throws InterruptedException {
//        this.btn_Girar.setVisible(false);
//        this.btn_false.setVisible(true);
//        this.btn_true.setVisible(true);
//        int vueltas = 0;
//        while (true) {
//            ruleta_circulo.setRotate(rotacion);
//            rotacion += 60;
//            if (rotacion > 400) {
//                rotacion = 40;
//            }
//            vueltas++;
//            if (vueltas == 20) {
//                vueltas = (int) (Math.random() * 400);
//                if (vueltas <= 40) {
//                    region = region.AMAZONIA;
//                    ruleta_circulo.setRotate(40);
//                    break;
//                }
//                if (vueltas <= 100) {
//                    region = region.COSTA;
//                    rotacion = 100;
//                    ruleta_circulo.setRotate(rotacion);
//                    break;
//                }
//                if (vueltas > 100 && vueltas <= 160) {
//                    region = region.SIERRA;
//                    rotacion = 160;
//                    ruleta_circulo.setRotate(rotacion);
//                    break;
//                }
//                if (vueltas > 160 && vueltas <= 220) {
//                    region = region.COSTA;
//                    rotacion = 220;
//                    ruleta_circulo.setRotate(rotacion);
//                    break;
//                }
//                if (vueltas > 220 && vueltas <= 280) {
//                    region = region.ORIENTE;
//                    rotacion = 280;
//                    ruleta_circulo.setRotate(rotacion);
//                    break;
//                }
//                if (vueltas > 280) {
//                    region = region.GALAPAGOS;
//                    rotacion = 340;
//                    ruleta_circulo.setRotate(rotacion);
//                    break;
//                }
//                break;
//            }
//
//
//        }
//        vueltas = 0;
//        count = (int) (Math.random() * reg_conjunto.getComidas().size());
//        Iterator value = reg_conjunto.getComidas().iterator();
//        while (value.hasNext()) {
//            if (vueltas == count) {
//                comida = (String) value.next();
//                pregunta.setText("Este platillo '" + comida + "' pertenece a la region " + region.toString());
//            } else {
//                value.next();
//            }
//            vueltas++;
//        }
//
//    }
//
//    @FXML
//    public void respuesta_si() {
//        if (this.num_preguntasMax >= 1) {
//            if (comidasporRegion.get(comida).split(",")[0].equals(region.toString())) {
//                punt++;
//                this.respuesta.setText("Correcto");
//                System.out.println("correcto");
//                this.agregarRespuesta(Integer.parseInt(comidasporRegion.get(comida).split(",")[2]),
//                        Integer.parseInt(comidasporRegion.get(comida).split(",")[1]));
//            } else {
//                this.respuesta.setText("Incorrecto,"+"la comida "+comida+ " pertenece a la region " + comidasporRegion.get(comida).split(",")[0]);
//                System.out.println("Incorrecto");
//                if (punt > 0) {
//                    punt--;
//                }
//            }
//            num_preguntasMax--;
//            this.puntos.setText(String.valueOf(this.num_preguntasMax));
//            try {
//                Rotate();
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//        }else{
//            calcularPuntaje();
//        }
//
//    }
//
//    @FXML
//    public void respuesta_no() {
//        if(this.num_preguntasMax>=1){
//            if (!comidasporRegion.get(comida).split(",")[0].equals(region.toString())) {
//                punt++;
//                this.respuesta.setText("Correcto");
//                System.out.println("correcto");
//
//                this.agregarRespuesta(Integer.parseInt(comidasporRegion.get(comida).split(",")[2]),
//                        Integer.parseInt(comidasporRegion.get(comida).split(",")[1]));
//            } else {
//                System.out.println("Incorrecto");
//                this.respuesta.setText("Incorrecto,"+"la comida "+comida+ " pertenece a la region " + comidasporRegion.get(comida).split(",")[0]);
//                if(punt>0)
//                    punt--;
//            }
//            num_preguntasMax--;
//            this.puntos.setText(String.valueOf(this.num_preguntasMax));
//            try {
//                Rotate();
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//        }else{
//            calcularPuntaje();
//        }
//
//    }
//
//}