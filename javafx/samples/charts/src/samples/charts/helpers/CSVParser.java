package samples.charts.helpers;

import samples.charts.models.FoodConsumption;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CSV Reader Helper Class for Graphs.
 *
 * @author Saumil
 *
 * Created on 2014/05/02 22:33:00.
 */
public class CSVParser {
    public static List<FoodConsumption> getFoodConsumptionData(final String chartType) throws IOException {
        List<FoodConsumption> data = new ArrayList<FoodConsumption>();

        InputStream in = CSVParser.class.getResourceAsStream("../../../Resources/"+ chartType +"_data.csv");
        Scanner scanner = new Scanner(in);

        //Read CSV line by line
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            FoodConsumption fc = parseLine(scanner.next());
            data.add(fc);
        }
        scanner.close();

        return data;
    }

    /**
     * Method parses and returns <code>FoodConsumption</code> Object.
     *
     * @param line  String Representation of data
     * @return  FoodConsumption Model
     */
    public static FoodConsumption parseLine(String line){
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter("\\s*,\\s*");

        int id = Integer.valueOf( scanner.next() );
        String cType = scanner.next().replace("\"", "");
        String strCValue = scanner.next().replace("\"", "");
        double cValue = Double.valueOf(strCValue);
        String cCode = scanner.next().replace("\"", "");
        String cName = scanner.next().replace("\"", "");

        return new FoodConsumption(id, cType, cValue, cCode, cName);
    }

    /**
     * Extracts Distinct Food Consumption Types
     * @param inList List of Food Consumption Data
     * @return List of Consumption Types
     */
    public static List<String> getDistinctCategory(final List<FoodConsumption> inList){
        List<String> retList = new ArrayList<String>();
        if( inList != null && !inList.isEmpty() ){
            for(final FoodConsumption d : inList ){
                if ( !retList.contains( d.getConsumptionType() ) ) {
                    retList.add(d.getConsumptionType());
                }
            }
        }
        return retList;
    }

}
