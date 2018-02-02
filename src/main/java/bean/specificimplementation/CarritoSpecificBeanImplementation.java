package bean.specificimplementation;

import com.google.gson.annotations.Expose;

public class CarritoSpecificBeanImplementation {

    @Expose
    private Integer cantidad;
    @Expose
    private PlatoSpecificBeanImplementation oPlato;
    @Expose(serialize = false)
    private Integer id_plato = 0;

    public CarritoSpecificBeanImplementation(Integer cantidad, PlatoSpecificBeanImplementation oPlato) {
        this.cantidad = cantidad;
        this.oPlato = oPlato;
    }

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

    public PlatoSpecificBeanImplementation getoPlato() {
        return oPlato;
    }

    public void setoPlato(PlatoSpecificBeanImplementation oPlato) {
        this.oPlato = oPlato;
    }

}
