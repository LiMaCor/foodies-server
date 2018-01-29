package bean.specificimplementation;

import com.google.gson.annotations.Expose;
import bean.genericimplementation.TableGenericBeanImplementation;
import bean.meta.publicinterface.MetaObjectBeanInterface;
import bean.meta.publicinterface.MetaPropertyBeanInterface;
import helper.EnumHelper;
import helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "tipousuario",
        SingularDescription = "Tipo de usuario",
        PluralDescription = "Tipos de usuarios",
        Icon = "fa fa-user-o",
        Type = EnumHelper.SourceType.Table
)

public class TipousuarioSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Tipo",
            LongName = "Tipo de usuario",
            Description = "Tipo de usuario dentro del sistema",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = true
    )
    private String descripcion = "";

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Usuarios del tipo",
            LongName = "Usuarios del tipo",
            Description = "Usuarios del tipo",
            Type = EnumHelper.FieldType.Link,
            References = "usuario"
    )
    private Integer link_usuario = null;

    public TipousuarioSpecificBeanImplementation() {
    }

    public TipousuarioSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }
}
