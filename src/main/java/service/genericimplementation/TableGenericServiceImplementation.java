package service.genericimplementation;

import service.publicinterface.TableServiceInterface;
import com.google.gson.Gson;
import bean.genericimplementation.TableGenericBeanImplementation;
import bean.helper.MetaBeanHelper;
import bean.helper.ReplyBeanHelper;
import connection.publicinterface.ConnectionInterface;
import helper.constant.ConfigurationConstants;
import helper.Log4jHelper;
import factory.BeanFactory;
import factory.DaoFactory;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import helper.EncodingHelper;
import dao.publicinterface.TableDaoInterface;
import factory.ConnectionFactory;
import helper.constant.ConnectionConstants;
import helper.GsonHelper;

public abstract class TableGenericServiceImplementation extends ViewGenericServiceImplementation implements TableServiceInterface {

    public TableGenericServiceImplementation(HttpServletRequest request) {
        super(request);
    }

    @Override
    public ReplyBeanHelper get() throws Exception {
        if (this.checkPermission("get")) {
            int id = Integer.parseInt(oRequest.getParameter("id"));
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBeanHelper oReplyBean = null;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                TableDaoInterface oDao = (TableDaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                MetaBeanHelper oMetaBeanHelper = (MetaBeanHelper) oDao.get(id, ConfigurationConstants.jsonMsgDepth);
                String strJson = GsonHelper.getGson().toJson(oMetaBeanHelper);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    private ReplyBeanHelper setoBean(TableGenericBeanImplementation oBean) throws Exception {
        Connection oConnection = null;
        ConnectionInterface oPooledConnection = null;
        ReplyBeanHelper oReplyBean = null;
        int iResult = 0;
        try {
            oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
            oConnection = oPooledConnection.newConnection();
            TableDaoInterface oDao = (TableDaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
            iResult = oDao.set(oBean);
            Gson oGson = GsonHelper.getGson();
            String strJson = oGson.toJson(iResult);
            oReplyBean = new ReplyBeanHelper(200, strJson);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        } finally {
            if (oConnection != null) {
                oConnection.close();
            }
            if (oPooledConnection != null) {
                oPooledConnection.disposeConnection();
            }
        }
        return oReplyBean;
    }

    @Override
    public ReplyBeanHelper set() throws Exception {
        if (this.checkPermission("set")) {
            String jason = oRequest.getParameter("json");
            TableGenericBeanImplementation oBean = (TableGenericBeanImplementation) BeanFactory.getBean(ob, (MetaBeanHelper) oRequest.getSession().getAttribute("user"));
            Gson oGson = GsonHelper.getGson();
            oBean = oGson.fromJson(jason, oBean.getClass());
            ReplyBeanHelper oReplyBean = null;
            if (oBean == null) {
                throw new Exception("Bean null en service set");
            } else {
                oReplyBean = setoBean(oBean);
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    @Override
    public ReplyBeanHelper remove() throws Exception {
        if (this.checkPermission("remove")) {
            int id = Integer.parseInt(oRequest.getParameter("id"));
            int iResult = 0;
            Connection oConnection = null;
            ConnectionInterface oPooledConnection = null;
            ReplyBeanHelper oReplyBean = null;
            try {
                oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                oConnection = oPooledConnection.newConnection();
                TableDaoInterface oDao = (TableDaoInterface) DaoFactory.getDao(ob, oConnection, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                iResult = oDao.remove(id);
                Gson oGson = GsonHelper.getGson();
                String strJson = oGson.toJson(iResult);
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            } finally {
                if (oConnection != null) {
                    oConnection.close();
                }
                if (oPooledConnection != null) {
                    oPooledConnection.disposeConnection();
                }
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

}
