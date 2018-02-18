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
import bean.meta.publicinterface.MetaObjectBeanInterface;
import bean.meta.publicinterface.MetaPropertyBeanInterface;
import helper.EnumHelper;
import helper.constant.RegexConstants;

@MetaObjectBeanInterface(
        TableName = "tienda",
        SingularDescription = "Tienda",
        PluralDescription = "Tiendas",
        Icon = "fa fa-university",
        Type = EnumHelper.SourceType.Table
)

public class TiendaSpecificBeanImplementation extends TableGenericBeanImplementation {

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Nombre",
            LongName = "Nombre de la tienda",
            Description = "Nombre de la tienda",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.capitalizedSentence,
            RegexHelp = RegexConstants.capitalizedSentence_Help,
            IsForeignKeyDescriptor = true
    )
    private String descripcion = "";

    @Expose
    @MetaPropertyBeanInterface(
            ShortName = "Dir.",
            LongName = "Dirección",
            Description = "Dirección de la tienda ",
            Type = EnumHelper.FieldType.String,
            IsRequired = true,
            RegexPattern = RegexConstants.direction,
            RegexHelp = RegexConstants.directionSentence_Help,
            IsForeignKeyDescriptor = false,
            Width = 3,
            MaxLength = 100,
            IsVisible = false
    )
    private String direccion;

    @Expose(deserialize = false)
    @MetaPropertyBeanInterface(
            ShortName = "Usuarios de la tienda",
            LongName = "Usuarios de la tienda",
            Description = "Usuarios asignados a la tienda",
            Type = EnumHelper.FieldType.Link,
            References = "usuario"
    )
    private Integer link_usuario = null;

    public TiendaSpecificBeanImplementation() {
    }

    public TiendaSpecificBeanImplementation(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
