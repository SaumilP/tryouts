package samples.charts.Controllers;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import samples.charts.helpers.CSVParser;
import samples.charts.models.FoodConsumption;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Pie Chart Controller Class.
 *
 * @author  SaumilP
 * Created on 2014/05/02 23:33:00.
 */
public class PieController extends BaseController {
    private static Logger logger = Logger.getLogger(PieController.class.getName());

    //This property links to fx:id in FXML
    @FXML private PieChart pieChart;

    /**
     * Method gets executed on Controller initialization
     */
    @FXML public void initialize(){
        this.CHART_TYPE = "pie";
        this.pieChart.setData( FXCollections.observableArrayList(fetchPieData("IN")) );
        attachMouseEvent();
    }

    /**
     * Method attaches MouseEvent to individual Pie Slice
     */
    private void attachMouseEvent() {
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");

        for(final PieChart.Data slice : this.pieChart.getData() ){
            slice.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    caption.setTranslateX( event.getSceneX() );
                    caption.setTranslateY( event.getSceneY() );
                    caption.setText( String.valueOf(slice.getPieValue()) + "%" );
                }
            });
        }
    }

    /**
     * Method converts CSV data to PieChart.data
     *
     * @param countryCode   Country code ( For better visibility )
     * @return
     */
    private static List<PieChart.Data> fetchPieData(final String countryCode){
        List<PieChart.Data> retList = new ArrayList<PieChart.Data>();
        try {
            List<FoodConsumption> pieData = CSVParser.getFoodConsumptionData(CHART_TYPE);
            if ( pieData != null && !pieData.isEmpty() ){
                for(FoodConsumption d : pieData ) {
                    if ( d.getCountryCode().contains(countryCode) ) {
                        retList.add(new PieChart.Data(d.getConsumptionType(), d.getConsumptionValue()));
                    }
                }
            }
        }catch( IOException ex){
            logger.log(Level.SEVERE, "Failed to parse Pie Data Resource : " + ex.getMessage());
        }
        return retList;
    }
}
