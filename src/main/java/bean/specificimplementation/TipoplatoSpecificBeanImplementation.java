package bean.specificimplementation;

import com.google.gson.annotations.Expose;
import bean.genericimplementation.TableGenericBeanImplementation;
import bean.meta.publicinterface.MetaObjectBeanInterface;
import bean.meta.publicinterface.MetaPropertyBeanInterface;
import helper.EnumHelper;
import helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "tipoplato",
        SingularDescription = "Tipo de plato",
        PluralDescription = "Tipos de platos",
        Icon = "fa fa-circle-o",
        Type = EnumHelper.SourceType.Table
)

public class TipoplatoSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Tipo",
            LongName = "Tipo de plato",
            Description = "Tipo de plato dentro del sistema",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = true
    )
    private String descripcion = "";
       
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Platos del tipo",
            LongName = "Platos del tipo",
            Description = "Plato del tipo",
            Type = EnumHelper.FieldType.Link,
            References = "plato"
    )
    private Integer link_plato = null;

    public TipoplatoSpecificBeanImplementation() {
    }

    public TipoplatoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }
}
