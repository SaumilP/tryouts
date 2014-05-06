import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * 1st Frame Controller responsible for navigating to 2nd Frame
 *
 * Created by saumil on 2014/05/02.
 */
public class Frame1Controller {
    @FXML
    void nextPane(ActionEvent event){
        FrameNavigator.loadFrame( FrameNavigator.FRAME_2);
    }
}
