package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.Loaders;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class VaultController implements EventHandler<ActionEvent>, Initializable {
    @FXML
    private AnchorPane outerAp, innerAp;
    @FXML
    private HBox buttons;
    @FXML
    private Button encrypt, decrypt, vault, savedKeys, home, save;
    @FXML
    private TextArea notepad;
    @FXML
    private Label state;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void handle(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        if (buttonText.equals("Encrypt"))
            Loaders.loadScene("EncryptView1.fxml");
        else if (buttonText.equals("Decrypt"))
            Loaders.loadScene("DecryptView1.fxml");
        else if (buttonText.equals("Saved Keys"))
            Loaders.loadScene("SavedKeysView1.fxml");
        else if (buttonText.equals("Home"))
            Loaders.loadScene("UserInteraction.fxml");
    }

}
