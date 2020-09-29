package ehu.isad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class ComboBoxExperiments extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("ComboBox Experiment 1");
        String mota="";
        ComboBox comboBox = new ComboBox();

        Label label = new Label();
        comboBox.getItems().add("BTC");
        comboBox.getItems().add("ETH");
        comboBox.getItems().add("LTC");
        comboBox.setEditable(false);
        comboBox.getSelectionModel().selectFirst();


        comboBox.setOnAction(e -> {
            System.out.println( comboBox.getValue());
            String mota1 = (String) comboBox.getValue();
            //System.out.printf(mota);
            mota1 = mota1.toLowerCase();
            try {
                System.out.printf(this.web(mota1));
                label.setText("1"+mota1.toUpperCase()+"=");

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        VBox vbox = new VBox(label,comboBox);

        Scene scene = new Scene(vbox, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.show();
            mota = (String) comboBox.getValue();
            //System.out.printf(mota);
            mota = mota.toLowerCase();
            URL webdiru = new URL("https://api.gdax.com/products/" + mota + "-eur/ticker");
            BufferedReader in = new BufferedReader(new InputStreamReader(webdiru.openStream()));
            String inputLine = in.readLine();
            in.close();
            System.out.printf(inputLine);
            label.setText("1"+mota.toUpperCase()+"=");
            //Gson gson= new Gson();
            //Txanpona txanpon = gson.fromJson(inputLine,Txanpona.class);
    }
    public String web(String pMota) throws Exception{
        URL webdiru = new URL("https://api.gdax.com/products/" + pMota + "-eur/ticker");
        BufferedReader in = new BufferedReader(new InputStreamReader(webdiru.openStream()));
        String inputLine = in.readLine();
        in.close();
        return inputLine;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
