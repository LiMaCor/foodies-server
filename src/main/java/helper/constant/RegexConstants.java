package helper.constant;

public class RegexConstants {

    public static final String dni = "[0-9]{8,8}[A-Z]";
    public static final String dni_Help = "ocho dígitos y una letra mayúscula";
    public static final String capitalizedName = "([A-Z]{1}[a-zçñáéíóúàèò]+[\\s]*)+";
    public static final String capitalizedName_Help = "una o varias palabras que todas comienzan en mayúcula";
    public static final String nameWithEndingNumbers = "[a-z][a-z0-9]+";
    public static final String nameWithEndingNumbers_Help = "un texto en minúsculas que puede acabar en dígitos";
    public static final String email = "[a-z]+[a-z0-9._]+@[a-z]+\\.[a-z.]{2,5}"; // see \\ is \    
    public static final String email_Help = "un email válido"; // see \\ is \    
    public static final String capitalizedSentence = "[A-Z]([^\\s]*\\s?)+";
    public static final String capitalizedSentence_Help = "una frase que comienza en mayúscula";
    public static final String direction = "[A-Z]{1}[a-z0-9ºçñáéíóúàèò- ]*";
    public static final String directionSentence_Help = "una direccion que comienza en mayúscula";
}

