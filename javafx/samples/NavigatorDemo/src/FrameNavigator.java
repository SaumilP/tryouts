import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

/**
 * Created by saumil on 2014/05/02.
 */
public class FrameNavigator {

    public static final String MAIN = "main.fxml";
    public static final String FRAME_1 = "frame1.fxml";
    public static final String FRAME_2 = "frame2.fxml";

    private static MainController mainController;

    public static void setMainController(MainController mainController) {
        FrameNavigator.mainController = mainController;
    }

    public static void loadFrame(String fxml) {
        try {
            mainController.setFrame(
                    (Node)FXMLLoader.load(
                            FrameNavigator.class.getResource(
                                    fxml
                            )
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
