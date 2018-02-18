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
package dao.specificimplementation;

import bean.helper.MetaBeanHelper;
import bean.specificimplementation.UsuarioSpecificBeanImplementation;
import dao.genericimplementation.TableGenericDaoImplementation;
import helper.Log4jHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioSpecificDaoImplementation extends TableGenericDaoImplementation {

    public UsuarioSpecificDaoImplementation(Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        super("usuario", oPooledConnection, oPuserBean_security, strWhere);
    }
    // metodo para el java web token
    public static boolean validacion(String login, String password) {
        UsuarioSpecificBeanImplementation oBean = new UsuarioSpecificBeanImplementation();
        return (login.equals(oBean.getLogin()) && password.equals(oBean.getPassword()));
    }

    public MetaBeanHelper getFromLoginAndPass(UsuarioSpecificBeanImplementation oUsuarioBean) throws Exception {
        PreparedStatement oPreparedStatement = null;
        ResultSet oResultSet = null;
        MetaBeanHelper oMetaBeanHelper = null;
        strSQL += " AND login='" + oUsuarioBean.getLogin() + "'";
        strSQL += " AND password='" + oUsuarioBean.getPassword() + "'";
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                oUsuarioBean.setId(oResultSet.getInt("id"));
                oMetaBeanHelper = this.get(oUsuarioBean.getId(), 3);
            } else {
                throw new Exception("UsuarioDao getFromLoginAndPass error");
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return oMetaBeanHelper;
    }

    public Integer getIDfromUser(String strLogin) throws Exception {
        Integer intResult = null;
        Statement oStatement = null;
        ResultSet oResultSet = null;
        try {
            oStatement = (Statement) oConnection.createStatement();
            String strSQL = "SELECT id FROM usuario WHERE login ='" + strLogin + "'";
            oResultSet = oStatement.executeQuery(strSQL);
            if (oResultSet.next()) {
                intResult = oResultSet.getInt("id");
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oStatement != null) {
                oStatement.close();
            }
        }
        return intResult;
    }
}
