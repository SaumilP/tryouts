import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class MainController {
    @FXML
    private StackPane frameHolder;

    public void setFrame(Node node){
        frameHolder.getChildren().setAll( node );
    }
}
