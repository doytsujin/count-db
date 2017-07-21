package be.bagofwords.db.methods;

import be.bagofwords.exec.RemoteClass;

import java.nio.charset.StandardCharsets;

/**
 * Created by koen on 1/07/17.
 */
@RemoteClass
public class StringSerializer implements ObjectSerializer<String> {

    private static final String NULL_VALUE = "xxx_NULL";

    @Override
    public void writeValue(String obj, DataStream ds) {
        writeStringValue(obj, ds);
    }

    @Override
    public String readValue(DataStream ds, int size) {
        return readStringValue(ds, size);
    }

    @Override
    public int getObjectSize() {
        return -1;
    }

    public static String readStringValue(DataStream ds, int size) {
        byte[] bytes = ds.readBytes(size);
        String result = new String(bytes, StandardCharsets.UTF_8);
        if (result.equals(NULL_VALUE)) {
            result = null;
        }
        return result;
    }

    public static void writeStringValue(String obj, DataStream ds) {
        if (obj == null) {
            obj = NULL_VALUE;
        }
        byte[] bytes = obj.getBytes(StandardCharsets.UTF_8);
        ds.writeBytes(bytes);
    }
}

