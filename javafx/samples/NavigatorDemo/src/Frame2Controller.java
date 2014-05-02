import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * 2nd Frame Controller contains method pointing to 1st Frame FXML
 *
 * Created by saumil on 2014/05/02.
 */
public class Frame2Controller {

    @FXML
    void previousPane(ActionEvent event){
        FrameNavigator.loadFrame(FrameNavigator.FRAME_1);
    }
}
