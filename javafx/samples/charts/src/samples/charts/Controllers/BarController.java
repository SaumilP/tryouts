package samples.charts.Controllers;

import com.sun.javafx.charts.Legend;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import samples.charts.helpers.CSVParser;
import samples.charts.models.FoodConsumption;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by saumil on 2014/05/03.
 */
public class BarController extends BaseController {
    private static Logger logger = Logger.getLogger(BarController.class.getName() );
    @FXML private BarChart<String, Number> barChart;

    @FXML public void initialize(){
        this.CHART_TYPE = "bar";
        this.barChart.setData(FXCollections.observableArrayList(getBarChartSeries()));
    }

    private List<XYChart.Series<String, Number>> getBarChartSeries(){
        List<XYChart.Series<String, Number>> retList = new ArrayList<>();

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        Legend legend = new Legend();
        this.barChart.setTitle("Food Consumption");
        xAxis.setLabel("Consumption Type");
        yAxis.setLabel("Value");

        try {
            List<FoodConsumption> barData = CSVParser.getFoodConsumptionData(CHART_TYPE);
            List<String> cTypes = CSVParser.getDistinctCategory( barData );

            if ( cTypes != null && !cTypes.isEmpty() ){
                for(String type : cTypes ) {
                    legend.getItems().add( new Legend.LegendItem(type));
                }
            }

            if ( barData != null && !barData.isEmpty() ){
                for ( final String type : cTypes) {
                    XYChart.Series series = new XYChart.Series();

                    for(FoodConsumption fc : barData ){
                        if( fc.getConsumptionType().compareTo(type) == 0 ){
                            series.setName( fc.getConsumptionType() );
                            series.getData().add( new XYChart.Data( fc.getCountryName(), fc.getConsumptionValue() ) );
                        }
                    }

                    retList.add(series);
                }
            }
            this.barChart.setLegendSide(Side.BOTTOM);
            this.barChart.setLegendVisible(true);
            this.barChart.setAnimated(true);
        } catch( Exception ex ){
            logger.log(Level.SEVERE, "Failed to construct Series Chart Data : " + ex.getMessage() );
        }

        return retList;
    }
}
