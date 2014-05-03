package items.organizer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Class uses Java8 Lambdas to prepare Image URLs.
 *
 */
public class Main extends Application {

    public static final String IMAGE_URL = "http://icons.iconarchive.com/icons/manda-pie/chocolate/128/chocolate";

    public static final String Suffix = "-icon.png";

    public static final ObservableList<String> chocolates = FXCollections.observableArrayList(
            "-1",
            "-1w",
            "-2",
            "-2w",
            "-3",
            "-3w",
            "-4",
            "-4w",
            "-5",
            "-5w"
    );

    public static final ObservableList<Image> chocolateImages = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Item Organizer");
        chocolates.forEach( sweet -> chocolateImages.add(new Image(IMAGE_URL + sweet + Suffix)));

        ListView<String> chocolateList = new ListView<>(chocolates);
        chocolateList.setCellFactory(param -> new ChocolateCell(chocolateImages) );
        chocolateList.setPrefWidth(180);

        VBox layout = new VBox(chocolateList);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public class ChocolateCell extends javafx.scene.control.ListCell<String> {

        private final ImageView imageView = new ImageView();

        public ChocolateCell(ObservableList<Image> chocolateImages){
            ListCell thisCell = this;

            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            setAlignment(Pos.CENTER);

            setOnDragDetected(event -> {
                if ( getItem() == null ){
                    return;
                }

                ObservableList<String> items = getListView().getItems();

                Dragboard dragboard = startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent() ;
                content.putString(getItem());
                dragboard.setDragView(
                        chocolateImages.get( items.indexOf(getItem() ))
                );
                dragboard.setContent(content);

                event.consume();
            });

            setOnDragOver(event -> {
                if ( event.getGestureSource() != thisCell &&
                        event.getDragboard().hasString()
                        ){
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();;
            });

            setOnDragEntered(event -> {
                if ( event.getGestureSource() != thisCell &&
                        event.getDragboard().hasString() ){
                    setOpacity(0.3);
                }
            });

            setOnDragExited(event -> {
                if (event.getGestureSource() != thisCell &&
                        event.getDragboard().hasString()) {
                    setOpacity(1);
                }
            });

            setOnDragDropped(event -> {
                if ( getItem()== null ){
                    return;
                }
                Dragboard db = event.getDragboard();
                boolean success = false;
                if ( db.hasString() ){
                    ObservableList<String> items = getListView().getItems();
                    int draggedIdx = items.indexOf(db.getString());
                    int thisIdx = items.indexOf(getItem());

                    Image tmp = chocolateImages.get(draggedIdx);
                    chocolateImages.set(draggedIdx, chocolateImages.get(thisIdx));
                    chocolateImages.set(thisIdx, tmp);

                    items.set(draggedIdx, getItem());
                    items.set(thisIdx, db.getString());

                    List<String> copyItems = new ArrayList<>( getListView().getItems() );
                    getListView().getItems().setAll(copyItems);

                    success = true;
                }
                event.setDropCompleted(success);

                event.consume();
            });

            setOnDragDone(DragEvent::consume);
        }

        @Override
        protected void updateItem(String item, boolean empty ){
            super.updateItem(item, empty);

            if ( empty || item == null ){
                setGraphic(null);
            } else {
                imageView.setImage( chocolateImages.get(getListView().getItems().indexOf(item)));
                setGraphic(imageView);
            }
        }
    }
}
