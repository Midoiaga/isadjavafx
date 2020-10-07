package ehu.isad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField testErab;

    @FXML
    private PasswordField pasPass;

    @FXML
    private Button btnKauto;

    @FXML
    void onClick(ActionEvent event) {
        System.out.printf(testErab.getText()+":"+pasPass.getText());
    }

}
