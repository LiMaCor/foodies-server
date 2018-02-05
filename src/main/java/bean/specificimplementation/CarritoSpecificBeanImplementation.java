package bean.specificimplementation;

import bean.genericimplementation.TableGenericBeanImplementation;
import bean.helper.MetaBeanHelper;
import bean.meta.publicinterface.MetaObjectBeanInterface;
import bean.meta.publicinterface.MetaPropertyBeanInterface;
import com.google.gson.annotations.Expose;
import helper.EnumHelper;

@MetaObjectBeanInterface(        
        SingularDescription = "Carrito",
        PluralDescription = "Carrito",
        Icon = "fas fa-shopping-cart",
        Type = EnumHelper.SourceType.Table
)
public class CarritoSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Cnt.",
            LongName = "Cantidad",
            Description = "Cantidad de platos",
            Type = EnumHelper.FieldType.Integer,
            IsRequired = true,
            RegexPattern = "[0-9]",
            RegexHelp = "Solo dígitos",
            MaxLength = 5,
            IsForeignKeyDescriptor = true,
            IsVisible = true
    )
    private Integer cantidad = 0;
    //--
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_plato = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Plato",
            LongName = "Plato",
            Description = "Plato",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "plato",
            Width = 4
    )
    private MetaBeanHelper obj_plato = null;

    public CarritoSpecificBeanImplementation() {
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getId_plato() {
        return id_plato;
    }

    public void setId_plato(Integer id_plato) {
        this.id_plato = id_plato;
    }

    public MetaBeanHelper getObj_plato() {
        return obj_plato;
    }

    public void setObj_plato(MetaBeanHelper obj_plato) {
        this.obj_plato = obj_plato;
    }

}
