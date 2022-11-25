package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.Loaders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class UserInteractionController implements Initializable {
    @FXML
    private AnchorPane outerAp, innerAp;
    @FXML
    private HBox buttons;
    @FXML
    private Button encrypt, decrypt, vault, savedKeys;
    @FXML
    private Circle eCircle, dCircle, vCircle, skCircle;
    private Loaders loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	loader = new Loaders();
        outerAp.setStyle("-fx-border-color: black; -fx-border-width: 3px 3px 3px 3px");
        outerAp.setBackground(new Background(
                new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        buttons.setSpacing(10);
        buttons.setPadding(new Insets(30, 30, 30, 18));
        //buttons.setStyle("-fx-border-color: black; -fx-border-width: 3px 3px 3px 3px");
        buttons.getStyleClass().add("hbox");
        innerAp.setStyle("-fx-border-color: black; -fx-border-width: 3px 3px 3px 3px");
        //Sets background color to blue after CSS is applied. Delete bottom line for default value of white. -dbiv
        innerAp.setStyle("-fx-background-color: #0198fc;");
        
        setImages();
    }
    
    public void handle(ActionEvent event) {
    	
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        
        if (buttonText.equals("Encrypt"))
        	loader.loadSceneEncrypt();
        else if (buttonText.equals("Decrypt"))
            loader.loadSceneDecrypt();
        else if (buttonText.equals("Vault"))
            loader.loadSceneVault();
        else if (buttonText.equals("Saved Keys"))
            loader.loadSceneKeys();
    }
    
    /**
     * handleCircle handle mouse events generated from the 4 circles.
     * 
     * @param e
     */
    public void handleCircle(MouseEvent e) {
    	Circle circle = (Circle) e.getSource();
		String circleText = circle.getId();
		
		if (circleText.equals("eCircle")) loader.loadSceneEncrypt();
		else if (circleText.equals("dCircle")) loader.loadSceneDecrypt();
		else if (circleText.equals("vCircle")) loader.loadSceneVault();
		else if (circleText.equals("skCircle")) loader.loadSceneKeys();
    }
    
    /**
     * Cleans up code in initialize method. Sets images within each circle.
     * 
     * 
     */
    public void setImages() {
    	 eCircle.setFill(new ImagePattern(new Image("file:data/encrypt.png", false)));
         eCircle.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
         dCircle.setFill(new ImagePattern(new Image("file:data/decrypt.png", false)));
         dCircle.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLUE));
         vCircle.setEffect(new DropShadow(+25d, 0d, +2d, Color.WHITE));
         vCircle.setFill(new ImagePattern(new Image("file:data/vault.jpg", false)));
         skCircle.setEffect(new DropShadow(+25d, 0d, +2d, Color.WHITE));
         skCircle.setFill(new ImagePattern(new Image("file:data/keys.png", false)));
    }
}