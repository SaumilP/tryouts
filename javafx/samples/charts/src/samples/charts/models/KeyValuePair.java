package samples.charts.models;

/**
 * Created by saumil on 2014/05/02.
 */
public class KeyValuePair {
    private String key;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private double value;

    public KeyValuePair(String key, double value){
        this.key = key;
        this.value = value;
    }
}
