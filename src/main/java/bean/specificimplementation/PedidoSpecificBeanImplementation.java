package bean.specificimplementation;

import com.google.gson.annotations.Expose;
import bean.genericimplementation.TableGenericBeanImplementation;
import bean.helper.MetaBeanHelper;
import bean.meta.publicinterface.MetaObjectBeanInterface;
import bean.meta.publicinterface.MetaPropertyBeanInterface;
import helper.EnumHelper;
import java.util.Date;

@MetaObjectBeanInterface(
        TableName = "pedido",
        SingularDescription = "Pedido",
        PluralDescription = "Pedidos",
        Icon = "fa fa-archive",
        Type = EnumHelper.SourceType.Table
)

public class PedidoSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "F.ped.",
            LongName = "Fecha de pedido",
            Description = "Fecha del pedido",
            Type = EnumHelper.FieldType.Date,
            RegexHelp = "una fecha correcta",
            IsRequired = true,
            IsVisible = true
    )
    private Date fecha_pedido;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_tienda = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Tienda",
            LongName = "Tienda",
            Description = "Tienda la que pertenece",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "tienda",
            Width = 4
    )
    private MetaBeanHelper obj_tienda = null;

   
    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_usuario = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Usuario",
            LongName = "Usuario",
            Description = "Usuario",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "usuario",
            Width = 4
    )
    private MetaBeanHelper obj_usuario = null;

    public PedidoSpecificBeanImplementation() {
    }

    public PedidoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Integer getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(Integer id_tienda) {
        this.id_tienda = id_tienda;
    }

    public MetaBeanHelper getObj_tienda() {
        return obj_tienda;
    }

    public void setObj_tienda(MetaBeanHelper obj_tienda) {
        this.obj_tienda = obj_tienda;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public MetaBeanHelper getObj_usuario() {
        return obj_usuario;
    }

    public void setObj_usuario(MetaBeanHelper obj_usuario) {
        this.obj_usuario = obj_usuario;
    }

}
