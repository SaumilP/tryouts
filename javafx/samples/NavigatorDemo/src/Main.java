import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Navigator Demo");
        primaryStage.setScene( createScene( loadMainPane() ) );
        primaryStage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        //Load default Pane
        Pane mainPane = (Pane)loader.load( Main.class.getResourceAsStream( FrameNavigator.MAIN ));

        //Setup Main FrameNavigator with previously initialised Controller
        MainController mainController = loader.getController();
        FrameNavigator.setMainController(mainController);

        //Load 1st Frame
        FrameNavigator.loadFrame(FrameNavigator.FRAME_1);

        return mainPane;
    }

    /**
     * Creates the main application screne.
     *
     * @param mainPane  Main Layout Pane
     * @return  Scene
     */
    private Scene createScene(Pane mainPane){
        Scene scene = new Scene(mainPane);

        scene.getStylesheets().setAll( getClass().getResource("frame.css").toExternalForm());

        return scene;
    }

    /**
     * Default Entry Point
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
