package by.pvt.home;

public class DataService {
    private static final String PREFIX = "Value is ";

    public String addValue(DataClazz dataClazz){
        return PREFIX.concat(dataClazz.getValue());
    }

    public String getId(Integer id) {
        if (Integer.valueOf(133).equals(id)) {
            throw new IllegalArgumentException("error");
        }
        return id.toString();
    }
}
