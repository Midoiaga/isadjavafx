package ehu.isad;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.skin.ListViewSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ComboBoxExperiments extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {
//////////      BITCOIN      //////////////////////////////////////////////////////////
//        primaryStage.setTitle("ComboBox Experiment 1");
//        String mota="";
//        ComboBox comboBox = new ComboBox();
//
//        Label label = new Label();
//        comboBox.getItems().add("BTC");
//        comboBox.getItems().add("ETH");
//        comboBox.getItems().add("LTC");
//        comboBox.setEditable(false);
//        comboBox.getSelectionModel().selectFirst();
//        comboBox.setOnAction(e -> {
//            System.out.println( comboBox.getValue());
//            String mota1 = (String) comboBox.getValue();
//            //System.out.printf(mota);
//            mota1 = mota1.toLowerCase();
//            try {
//                System.out.printf(this.web(mota1));
//                Gson gson= new Gson();
//                Txanpona txanpon = gson.fromJson(this.web(mota1),Txanpona.class);
//                label.setText("1"+mota1.toUpperCase()+"="+Float.toString(txanpon.price));
//
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//        });

     /*        mota = (String) comboBox.getValue();
            //System.out.printf(mota);
            mota = mota.toLowerCase();
            URL webdiru = new URL("https://api.gdax.com/products/" + mota + "-eur/ticker");
            BufferedReader in = new BufferedReader(new InputStreamReader(webdiru.openStream()));
            String inputLine = in.readLine();
            in.close();
            System.out.printf(inputLine);
            Gson gson= new Gson();
            Txanpona txanpon = gson.fromJson(inputLine,Txanpona.class);
            label.setText("1"+mota.toUpperCase()+"="+Float.toString(txanpon.price));
    */
        //////////////////////////////////////////////////////////////////////
        /////////////////// CACTUS/////////////////////////////////////////////
//        InputStream is = getClass().getResourceAsStream("/cactus.jpg");
//        BufferedImage reader = ImageIO.read(is);
//        Image image = SwingFXUtils.toFXImage(reader,null);
//        ImageView imageView = new ImageView(image);
//        VBox vbox = new VBox(imageView);
//        vbox.setAlignment(Pos.BASELINE_CENTER);
//        vbox.setPadding(new Insets(10,0,0,0));
        /////////////////////////////////////////////////////////////////////
        ListView<Argazki> listViewOfArgazki;
        ImageView imageView= new ImageView();
        ComboBox comboBilduma;
        comboBilduma = new ComboBox();
        List<String> bildumak = List.of("abereak", "landareak", "fruta");
        ObservableList<String> bildumaList = FXCollections.observableArrayList(bildumak);
        comboBilduma.setItems(bildumaList);
        Map<String, List<Argazki>> bildumaMap = new HashMap<>();
        bildumaMap.put("abereak", List.of(
                new Argazki("Elefantea", "elefantea.jpeg"),
                new Argazki("Txakurra", "txakurra.jpeg"),
                new Argazki("Untxia", "untxia.png")
        ));
        bildumaMap.put("landareak", List.of(
                new Argazki("Kaktusa", "cactus.png"),
                new Argazki("Berdea", "landareberdea.jpeg"),
                new Argazki("Ezezaguna", "landarehoria.jpeg")
        ));
        bildumaMap.put("fruta", List.of(
                new Argazki("Marrubia", "fresa.jpeg"),
                new Argazki("Sagarra", "sagarra.jpeg"),
                new Argazki("Sandia", "sandia.png")
        ));
        comboBilduma.setItems(bildumaList);
        ObservableList<Argazki> argazkiList = FXCollections.observableArrayList();
        argazkiList.addAll(bildumaMap.get("abereak"));
        listViewOfArgazki = new ListView<>(argazkiList);
        listViewOfArgazki.getSelectionModel().selectedItemProperty().addListener(  (observable, oldValue, newValue) -> {
            if (observable.getValue() == null) return;

            String fitx = observable.getValue().getFitx();

            try {

                imageView.setImage(lortuIrudia(fitx /* 48x48 */));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        comboBilduma.setOnAction(e -> {
            argazkiList.clear();
            argazkiList.addAll(bildumaMap.get(comboBilduma.getValue()));
                });



        VBox vbox=new VBox(comboBilduma,listViewOfArgazki,imageView);
        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Image lortuIrudia(String location) throws IOException {

        InputStream is = getClass().getResourceAsStream("/" + location);
        BufferedImage reader = ImageIO.read(is);
        return SwingFXUtils.toFXImage(reader, null);

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
