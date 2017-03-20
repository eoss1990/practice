package beanutils;

import org.apache.commons.beanutils.Converter;

/**
 * Created by yangyu on 2017/3/18.
 */
public class MyConverter implements Converter {
    @Override
    public <T> T convert(Class<T> type, Object value) {
        System.out.println(type.getName());
        System.out.println(value.toString());
        if ("yangyu".equals(value))
            value = "yangyuConverter";
        return (T) value;
    }
}
