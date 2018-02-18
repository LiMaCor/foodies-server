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

import bean.genericimplementation.TableGenericBeanImplementation;
import bean.helper.MetaBeanHelper;
import bean.meta.publicinterface.MetaObjectBeanInterface;
import bean.meta.publicinterface.MetaPropertyBeanInterface;
import com.google.gson.annotations.Expose;
import helper.EnumHelper;

@MetaObjectBeanInterface(        
        SingularDescription = "Carrito",
        PluralDescription = "Carrito",
        Icon = "fa fa-shopping-cart",
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
            RegexPattern = "[0-9]*",
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
