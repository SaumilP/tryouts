package sample;

import javafx.fxml.FXML;

/**
 * Controller class responsible for attaching events to UI
 */
public class Controller {
    @FXML protected void handleClickButtonAction(){
        System.out.println("User -> Hello");
    }
}
