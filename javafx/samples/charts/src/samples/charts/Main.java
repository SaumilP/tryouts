package samples.charts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load( getClass().getResource("fxml/bar.fxml"));
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(String.format("Chart Demo [ JavaFX Version: %s]", com.sun.javafx.runtime.VersionInfo.getRuntimeVersion()));
        this.primaryStage.setFullScreen(false);
        this.primaryStage.setScene(new Scene(root, 600, 590));
        this.primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
