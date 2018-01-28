package bean.meta.publicinterface;

import helper.EnumHelper;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //tells compiler and JVM that annotation should be accessible at runtime
@Target(ElementType.FIELD) // tells Java compiler that annotation can be used only on fields

public @interface MetaPropertyBeanInterface {

    public String ShortName() default "";

    public String LongName() default "";

    public String Description() default "";

    public String References() default "";

    public boolean IsForeignKeyDescriptor() default false;

    public EnumHelper.FieldType Type() default EnumHelper.FieldType.String;

    public boolean IsRequired() default false;

    public String RegexPattern() default "";

    public String RegexHelp() default "";

    public String DefaultValue() default "";

    public boolean IsVisible() default true;

    public int Width() default 2;

    public int MaxLength() default 255;

}
