package com.saka.logutil;

import com.saka.logutil.annotations.LogEntity;
import com.saka.logutil.annotations.LogField;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saka on 2017/9/4.
 */

public class AnnotationUtil {
    private List<Field> fieldList = new ArrayList<>();
    private List<Object> objectList = new ArrayList<>();

    public String getA(Object o) {
        Class clazz = (Class) o.getClass();

        if (!clazz.isAnnotationPresent(LogEntity.class)) {
            return o.toString();
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (Modifier.isStatic(f.getModifiers())) {
                LogField logField = f.getAnnotation(LogField.class);
                if (null == logField) {
                    continue;
                }
            }
            f.setAccessible(true);
            try {
                Object val = f.get(o);
                if (null == val) {
                    val = "null";
                }
                fieldList.add(f);
                objectList.add(val);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return KeyValueToString.wrapRect(fieldList, objectList);

    }
}
