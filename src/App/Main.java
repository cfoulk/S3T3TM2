package App;

import App.gui.component.loginController;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.svg.SVGGlyphLoader;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public void start(Stage primaryStage) throws IOException {
        //Load icons
        new Thread(() -> {
            try {
                //Prefix is the prefix to the name to be called (e.g. icomoon.svg.OdinLogo)
                SVGGlyphLoader.loadGlyphsFont(Main.class.getResourceAsStream("/font/icomoon.svg"),
                        "icomoon.svg");
            } catch (IOException ioExc) {
                ioExc.printStackTrace();
            }
        }).start();

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("App/gui/Login.fxml"));
        Parent root = loader.load();
        //TODO
        ((loginController) loader.getController()).setStage(primaryStage);


        primaryStage.setTitle("Odin Management");
//        JFXDecorator decorator = new JFXDecorator(primaryStage, root);
//        primaryStage.setScene(new Scene(decorator));
        primaryStage.setScene(new Scene(root));

        root.getStylesheets().add("App/gui/resource/css/odin_scheme.css");
        primaryStage.show();
    }
}
