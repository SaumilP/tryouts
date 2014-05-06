package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * <code>Main</code> class responsible for setting up Stage & scene from provided FXML file.
 *
 * @author SaumilP
 * Created on 2014/05/02
 */
public class Main extends Application {

    /**
     * Sets up stage using "sample.fxml" file.
     *
     * @param primaryStage  Default Primary Stage
     * @throws Exception    In case of missing or incorrect FXML
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    /**
     * Default Entry point in order to create JavaFx JAR file.
     * @param args  Application Arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
