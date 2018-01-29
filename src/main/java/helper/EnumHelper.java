package helper;

public class EnumHelper {

    public static enum Environment {
        Debug,
        Production
    };

    public static enum FieldType {
        Id,
        String,
        Integer,
        Decimal,
        Double,
        Date,
        Datetime,
        Boolean,
        ForeignId,
        ForeignObject,
        Link,
        Calculated,
        Password,
        Token
    };

    public static enum SourceType {
        View,
        Table
    };

}
