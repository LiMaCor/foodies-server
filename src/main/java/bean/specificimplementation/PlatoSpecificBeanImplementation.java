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
import helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "plato",
        SingularDescription = "Plato",
        PluralDescription = "Platos",
        Icon = "fa fa-cutlery",
        Type = EnumHelper.SourceType.Table
)

public class PlatoSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Plato",
            LongName = "Plato",
            Description = "Plato a elegir",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = true,
            IsVisible = true
    )
    private String descripcion = "";

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Img.",
            LongName = "Imagen",
            Description = "Imagen del plato",
            Type = EnumHelper.FieldType.Imagen,
            IsVisible = true
    )
    private String imagen = "";

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Exist",
            LongName = "Existencias",
            Description = "Existencias del plato",
            Type = EnumHelper.FieldType.Integer,
            IsRequired = true,
            RegexPattern = "[0-9]*",
            RegexHelp = "Solo dígitos",
            Width = 3,
            MaxLength = 5,
            IsVisible = true
    )
    private Integer existencias = 0;

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Precio",
            LongName = "Precio",
            Description = "Precio del plato",
            Type = EnumHelper.FieldType.Decimal,
            IsRequired = true,
            RegexPattern = "[0-9]*\\.?[0-9]*",
            RegexHelp = "Solo dígitos",
            Width = 3,
            MaxLength = 5,
            IsVisible = true
    )
    private Double precio = 0.0;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_tipoplato = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Tipo",
            LongName = "Tipo de plato",
            Description = "Tipo de plato",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "tipoplato",
            Width = 4
    )
    private MetaBeanHelper obj_tipoplato = null;

    @Expose(serialize = false)
    @MetaPropertyBeanInterface(
            Type = EnumHelper.FieldType.ForeignId
    )
    private Integer id_extras = 0;
    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Extras",
            LongName = "Extras",
            Description = "Extras de plato",
            Type = EnumHelper.FieldType.ForeignObject,
            IsRequired = true,
            References = "extras",
            Width = 4
    )
    private MetaBeanHelper obj_extras = null;

    public PlatoSpecificBeanImplementation() {
    }

    public PlatoSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getId_tipoplato() {
        return id_tipoplato;
    }

    public void setId_tipoplato(Integer id_tipoplato) {
        this.id_tipoplato = id_tipoplato;
    }

    public MetaBeanHelper getObj_tipoplato() {
        return obj_tipoplato;
    }

    public void setObj_tipoplato(MetaBeanHelper obj_tipoplato) {
        this.obj_tipoplato = obj_tipoplato;
    }

    public Integer getId_extras() {
        return id_extras;
    }

    public void setId_extras(Integer id_extras) {
        this.id_extras = id_extras;
    }

    public MetaBeanHelper getObj_extras() {
        return obj_extras;
    }

    public void setObj_extras(MetaBeanHelper obj_extras) {
        this.obj_extras = obj_extras;
    }

}
