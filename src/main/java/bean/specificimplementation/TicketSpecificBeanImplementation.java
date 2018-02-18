
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
import java.util.Date;

@MetaObjectBeanInterface(
        TableName = "ticket",
        SingularDescription = "Ticket del pedido",
        PluralDescription = "Tickets de los pedidos",
        Icon = "fa fa-ticket",
        Type = EnumHelper.SourceType.Table
)
public class TicketSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "F.ticket",
            LongName = "Fecha de ticket",
            Description = "Fecha de expedición del ticket",
            Type = EnumHelper.FieldType.Date,
            RegexHelp = "una fecha correcta",
            IsRequired = true,
            IsVisible = true
    )
    private Date fecha_ticket;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Iva",
            LongName = "Iva",
            Description = "Iva del producto",
            Type = EnumHelper.FieldType.Integer,
            IsRequired = true,
            IsForeignKeyDescriptor = true
    )
    private Integer iva = 0;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Desc.",
            LongName = "Descripcion",
            Description = "Descripcion",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = true
    )
    private String descripcion = "";

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_pedido = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Pedido",
            LongName = "Pedido",
            Description = "Pedido asociado al ticket",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "pedido",
            Width = 4
    )
    private MetaBeanHelper obj_pedido = null;

    public TicketSpecificBeanImplementation() {
    }

    public TicketSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public Date getFecha_ticket() {
        return fecha_ticket;
    }

    public void setFecha_ticket(Date fecha_ticket) {
        this.fecha_ticket = fecha_ticket;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public MetaBeanHelper getObj_pedido() {
        return obj_pedido;
    }

    public void setObj_pedido(MetaBeanHelper obj_pedido) {
        this.obj_pedido = obj_pedido;
    }

}
