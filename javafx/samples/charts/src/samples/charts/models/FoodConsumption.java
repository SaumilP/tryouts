package samples.charts.models;

/**
 * Dummy DTO class to serve Pie Chart Data.
 *
 * Created by SaumilP on 2014/05/02.
 */
public class FoodConsumption {
    private int id;
    private String countryName;
    private String countryCode;
    private String consumptionType;
    private Double consumptionValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(String consumptionType) {
        this.consumptionType = consumptionType;
    }

    public Double getConsumptionValue() {
        return consumptionValue;
    }

    public void setConsumptionValue(Double consumptionValue) {
        this.consumptionValue = consumptionValue;
    }

    public FoodConsumption() { }
    public FoodConsumption( int id, String consumptionType,
                            Double consumptionValue, String countryCode,
                            String countryName){
        this.consumptionType = consumptionType;
        this.consumptionValue = consumptionValue;
        this.countryCode = countryCode;
        this.countryName = countryName;
    }
}
