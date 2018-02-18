/*
 * Copyright (c) 2017-2018 
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 * 
 * GESANE: Free Open Source Health Management System
 *
 * Sources at:
 *                            https://github.com/rafaelaznar/gesane-server
 *                            https://github.com/rafaelaznar/gesane-client
 *                            https://github.com/rafaelaznar/gesane-database
 *
 * GESANE is distributed under the MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package bean.specificimplementation;

import com.google.gson.annotations.Expose;
import bean.genericimplementation.TableGenericBeanImplementation;
import bean.helper.MetaBeanHelper;
import bean.meta.publicinterface.MetaObjectBeanInterface;
import bean.meta.publicinterface.MetaPropertyBeanInterface;
import helper.EnumHelper;
import helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "lineapedido",
        SingularDescription = "Linea de Pedido",
        PluralDescription = "Lineas de Pedidos",
        Icon = "fa fa-list",
        Type = EnumHelper.SourceType.Table
)

public class LineapedidoSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Cantidad",
            LongName = "Cantidad",
            Description = "Cantidad de platos",
            Type = EnumHelper.FieldType.Integer,
            IsRequired = true,
            RegexPattern = "[0-9]*",
            RegexHelp = "Solo dígitos",
            MaxLength = 5,
            IsForeignKeyDescriptor = true,
            IsVisible = true
    )
    private Integer cantidad = 0;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Importe",
            LongName = "Importe",
            Description = "Importe del pedido",
            Type = EnumHelper.FieldType.Decimal,
            IsRequired = true,
            RegexPattern = "[0-9]*\\.?[0-9]*",
            RegexHelp = "Solo dígitos",
            IsForeignKeyDescriptor = true,
            IsVisible = true
    )
    private Double importe = 0.0;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_pedido = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Pedido",
            LongName = "Pedido",
            Description = "Pedido",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "pedido",
            Width = 4
    )
    private MetaBeanHelper obj_pedido = null;

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

    public LineapedidoSpecificBeanImplementation() {
    }

    public LineapedidoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedidoo) {
        this.id_pedido = id_pedidoo;
    }

    public MetaBeanHelper getObj_pedido() {
        return obj_pedido;
    }

    public void setObj_pedido(MetaBeanHelper obj_pedido) {
        this.obj_pedido = obj_pedido;
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
