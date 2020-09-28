package ehu.isad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
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

        comboBox.getItems().add("BTC");
        comboBox.getItems().add("ETH");
        comboBox.getItems().add("LTC");
        comboBox.setEditable(false);
        comboBox.getSelectionModel().selectFirst();

        comboBox.setOnAction(e -> {
            System.out.println( comboBox.getValue());

        });

        HBox hbox = new HBox(comboBox);
        int i=1;
        Scene scene = new Scene(hbox, 200, 120);
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
            Gson gson= new Gson();
            Txanpona txanpon = gson.fromJson(inputLine,Txanpona.class);
    }
    public class Txanpona{
        int trade_id;
        float price;
        float size;
        String time;
        float bid;
        float ask;
        float volume;
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
