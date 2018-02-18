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
package factory;

import java.sql.Connection;
import bean.helper.MetaBeanHelper;
import bean.specificimplementation.TipousuarioSpecificBeanImplementation;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;
import dao.publicinterface.MetaDaoInterface;
import dao.specificimplementation.ExtrasClienteSpecificDaoImplementation;
import dao.specificimplementation.ExtrasEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.ExtrasSpecificDaoImplementation;
import dao.specificimplementation.LineapedidoClienteSpecificDaoImplementation;
import dao.specificimplementation.LineapedidoEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.LineapedidoSpecificDaoImplementation;
import dao.specificimplementation.PedidoClienteSpecificDaoImplementation;
import dao.specificimplementation.PedidoEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.PedidoSpecificDaoImplementation;
import dao.specificimplementation.PlatoClienteSpecificDaoImplementation;
import dao.specificimplementation.PlatoEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.PlatoSpecificDaoImplementation;
import dao.specificimplementation.TicketClienteSpecificDaoImplementation;
import dao.specificimplementation.TicketEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.TicketSpecificDaoImplementation;
import dao.specificimplementation.TiendaClienteSpecificDaoImplementation;
import dao.specificimplementation.TiendaEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.TiendaSpecificDaoImplementation;
import dao.specificimplementation.TipoplatoClienteSpecificDaoImplementation;
import dao.specificimplementation.TipoplatoEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.TipoplatoSpecificDaoImplementation;
import dao.specificimplementation.TipousuarioClienteSpecificDaoImplementation;
import dao.specificimplementation.TipousuarioEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.TipousuarioSpecificDaoImplementation;
import dao.specificimplementation.UsuarioClienteSpecificDaoImplementation;
import dao.specificimplementation.UsuarioEmpleadoSpecificDaoImplementation;
import dao.specificimplementation.UsuarioSpecificDaoImplementation;

public class DaoFactory {

    public static MetaDaoInterface getDao(String ob, Connection oConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        MetaDaoInterface oDao = null;
        switch (ob) {
            case "usuario":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new UsuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new UsuarioEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new UsuarioClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;

            case "tipousuario":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new TipousuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new TipousuarioSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new TipousuarioEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new TipousuarioClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;

            case "tienda":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new TiendaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new TiendaSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new TiendaEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new TiendaClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;

            case "ticket":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new TicketSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new TicketSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new TicketEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new TicketClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;

            case "tipoplato":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new TipoplatoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new TipoplatoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new TipoplatoEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new TipoplatoClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;

            case "plato":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new PlatoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new PlatoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new PlatoEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new PlatoClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;

            case "pedido":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new PedidoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new PedidoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new PedidoEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new PedidoClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;
            case "lineapedido":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new LineapedidoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new LineapedidoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new LineapedidoEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new LineapedidoClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;
            case "extras":
                if (oPuserBean_security == null) {
                    oDao = (MetaDaoInterface) new ExtrasSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                    break;
                } else {
                    UsuarioSpecificBeanImplementation oUsuario = (UsuarioSpecificBeanImplementation) oPuserBean_security.getBean();
                    MetaBeanHelper oMetaBeanHelper = oUsuario.getObj_tipousuario();
                    TipousuarioSpecificBeanImplementation oTipoUsuario = (TipousuarioSpecificBeanImplementation) oMetaBeanHelper.getBean();
                    Integer idTipousuario = oTipoUsuario.getId();
                    switch (idTipousuario) {
                        case 1:
                            oDao = (MetaDaoInterface) new ExtrasSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 2:
                            oDao = (MetaDaoInterface) new ExtrasEmpleadoSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        case 3:
                            oDao = (MetaDaoInterface) new ExtrasClienteSpecificDaoImplementation(oConnection, oPuserBean_security, strWhere);
                            break;
                        default:
                            oDao = null;
                            break;
                    }
                }
                break;

            default:
                //oReplyBean = new ReplyBean(500, "Object not found : Please contact your administrator");
                break;
        }
        return oDao;
    }
}
