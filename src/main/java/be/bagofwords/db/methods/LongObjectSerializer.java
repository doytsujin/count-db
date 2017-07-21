package be.bagofwords.db.methods;

import be.bagofwords.exec.RemoteClass;

/**
 * Created by koen on 23/05/17.
 */
@RemoteClass
public class LongObjectSerializer implements ObjectSerializer<Long> {

    private final long NULL_VALUE = Long.MIN_VALUE;

    @Override
    public void writeValue(Long obj, DataStream ds) {
        if (obj == null) {
            obj = NULL_VALUE;
        } else if (obj == NULL_VALUE) {
            throw new RuntimeException("Sorry, value " + obj + " is a reserved value");
        }
        ds.writeLong(obj);
    }

    @Override
    public Long readValue(DataStream ds, int size) {
        Long value = ds.readLong();
        if (value == NULL_VALUE) {
            value = null;
        }
        return value;
    }

    @Override
    public int getObjectSize() {
        return 8;
    }
}
