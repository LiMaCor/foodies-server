package bean.meta.publicinterface;

import helper.EnumHelper;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //tells compiler and JVM that annotation should be accessible at runtime
@Target(ElementType.TYPE) // tells Java compiler that annotation can be used on both classes and interfaces

public @interface MetaObjectBeanInterface {

    public String Icon() default "fa-question-circle";

    public EnumHelper.SourceType Type() default EnumHelper.SourceType.Table;

    public String TableName() default "";

    public String SingularDescription() default "";

    public String PluralDescription() default "";

}
