package ehu.isad;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class TxanponAriketa extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //////////      BITCOIN      //////////////////////////////////////////////////////////
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
            String mota1 = (String) comboBox.getValue();
            mota1 = mota1.toLowerCase();
            try {
                Gson gson= new Gson();
                Txanpona txanpon = gson.fromJson(this.web(mota1),Txanpona.class);
                label.setText("1"+mota1.toUpperCase()+"="+Float.toString(txanpon.price));

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
            mota = (String) comboBox.getValue();
            mota = mota.toLowerCase();
            String inputLine= this.web(mota);
            Gson gson= new Gson();
            Txanpona txanpon = gson.fromJson(inputLine,Txanpona.class);
            label.setText("1"+mota.toUpperCase()+"="+Float.toString(txanpon.price));
        VBox vbox=new VBox(label,comboBox);
        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private String web(String pMota) throws Exception{
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
