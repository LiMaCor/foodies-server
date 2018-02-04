package bean.specificimplementation;

import bean.genericimplementation.TableGenericBeanImplementation;
import bean.helper.MetaBeanHelper;
import com.google.gson.annotations.Expose;

public class CarritoSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    private Integer cantidad;
    //--
    @Expose(serialize = false)
    private Integer id_plato = 0;
    @Expose(deserialize = false)
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
