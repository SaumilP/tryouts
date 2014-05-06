import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
* Simple HelloWorld Application.
*
* @author SaumilP
* Created on 2014/05/02
*/
public class HelloWorld extends Application {
	public static void main( String[] args ){
		launch(args);
	}

	/**
	* <p>This is the main entry point for current application. <br />
	* All JavaFx application defines the UI container by means of <code>Stage</code> and <code>Scene</code>.
	* </p>
	*/
	@Override
	public void start( Stage primaryStage ){
		primaryStage.setTitle ( "Hello world");

		//Create a button and bind new ActionEvent
		Button btn = new Button();
		btn.setText("Say 'Hello'");
		btn.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle( ActionEvent event ){
				System.out.println("User -> Hello");
			}
		});

		//Add Button to a new StackPane
		StackPane root = new StackPane();
		root.getChildren().add(btn);

		//Create a scene with StackPane
		primaryStage.setScene( new Scene( root, 300, 250));
		primaryStage.show();
	}
}
