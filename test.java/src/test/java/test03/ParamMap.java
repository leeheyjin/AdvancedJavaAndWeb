package test.java.test03;

import java.util.HashMap;

public class ParamMap extends HashMap<String, Object> {
    private ParamMap() {

    }

    public static ParamMap init() {
        return new ParamMap();
    }

    public String getString(String key) {
        Object object = this.get(key);
        if (object == null || object == "") {
            return null;
        } else {
            return String.valueOf(object);
        }
    }

    public Integer getInt(String key) {
        Object object = this.get(key);
        if (object == null) {
            return null;
        } else {
            return Integer.valueOf((String) object);
        }
    }

    public <T> T get(String key, Class<T> clazz) {
        Object object = this.get(key);
        return (T) object;
    }


}
