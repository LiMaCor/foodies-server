package helper;

import java.util.Date;
import java.text.SimpleDateFormat;

public class EncodingHelper {

    public static String quotate(String s) {
        if (s != null) {
            return "\"" + s + "\"";
        } else {
            return s;
        }
    }

    public static String stringifyAndQuotate(Date s) {
        if (s == null) {
            return "null";
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String value = format.format(s);
            return "\"" + value + "\"";
        }
    }

    public static String stringifyDate(Date s) {
        if (s == null) {
            return "null";
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String value = format.format(s);
            return value;
        }
    }

}
