package com.sak.logutil;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by saka on 2017/9/5.
 */

public class KeyValueToString {

    public static String wrapRect(List<Field> fields, List<Object> objects) {
        int filedLength = getFieldsMaxLength(fields);
        int valueLength = getObjectsMaxLength(objects);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.size(); i++) {
            addHeader(filedLength, valueLength, sb);
            addMsg(filedLength, fields.get(i).getName(), valueLength, objects.get(i).toString(), sb);
        }
        addFooter(filedLength, valueLength, sb);
        return sb.toString();
    }

    private static int getFieldsMaxLength(List<Field> objects) {
        int max = objects.get(0).getName().getBytes(Charset.forName("gbk")).length;
        for (int i = 1; i < objects.size(); i++) {
            if (objects.get(i).getName().getBytes(Charset.forName("gbk")).length > max) {
                max = objects.get(i).toString().getBytes(Charset.forName("gbk")).length;
            }
        }
        return max;
    }

    private static int getObjectsMaxLength(List<Object> objects) {
        int max = objects.get(0).toString().getBytes(Charset.forName("gbk")).length;
        for (int i = 1; i < objects.size(); i++) {
            if (objects.get(i).toString().getBytes(Charset.forName("gbk")).length > max) {
                max = objects.get(i).toString().getBytes(Charset.forName("gbk")).length;
            }
        }
        return max;
    }

    private static void addHeader(int filedLength, int valueLength, StringBuilder s) {
        s.append('+');
        for (int i = 0; i < filedLength + 2; i++) {
            s.append('-');
        }
        s.append('+');
        for (int i = 0; i < valueLength + 2; i++) {
            s.append('-');
        }
        s.append('+');
        s.append("\n");
    }

    private static void addMsg(int fieldLength, String fieldMsg, int valueLength, String valueMsg, StringBuilder s) {
        s.append("| ");
        s.append(fieldMsg);
        for (int i = 0; i < fieldLength + 1 - fieldMsg.getBytes(Charset.forName("gbk")).length; i++) {
            s.append(" ");
        }
        s.append("| ");
        s.append(valueMsg);
        for (int i = 0; i < valueLength + 1 - valueMsg.getBytes(Charset.forName("gbk")).length; i++) {
            s.append(" ");
        }
        s.append('|');
        s.append("\n");
    }

    private static void addFooter(int fieldLength, int valueLength, StringBuilder s) {
        s.append('+');
        for (int i = 0; i < fieldLength + 2; i++) {
            s.append('-');
        }
        s.append('+');
        for (int i = 0; i < valueLength + 2; i++) {
            s.append('-');
        }
        s.append('+');
    }

}
