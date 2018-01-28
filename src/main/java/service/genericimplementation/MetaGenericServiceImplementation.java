package service.genericimplementation;

import bean.helper.MetaBeanHelper;
import bean.helper.ReplyBeanHelper;
import dao.publicinterface.MetaDaoInterface;
import helper.EncodingHelper;
import helper.GsonHelper;
import helper.Log4jHelper;
import factory.DaoFactory;
import service.publicinterface.MetaServiceInterface;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

public abstract class MetaGenericServiceImplementation implements MetaServiceInterface {

    protected HttpServletRequest oRequest = null;
    protected String ob = null;

    public MetaGenericServiceImplementation(HttpServletRequest request) {
        oRequest = request;
        ob = oRequest.getParameter("ob");
    }

    protected Boolean checkPermission(String strMethodName) {
        MetaBeanHelper oUsuarioBean = (MetaBeanHelper) oRequest.getSession().getAttribute("user");
        if (oUsuarioBean != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ReplyBeanHelper getMetaData() throws Exception {
        ReplyBeanHelper oReplyBean = null;
        if (this.checkPermission("getMetaData")) {
            String data = null;
            try {
                MetaDaoInterface oDao = DaoFactory.getDao(ob, null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                HashMap alMeta = new HashMap();
                alMeta.put("metaObject", oDao.getObjectMetaData());
                alMeta.put("metaProperties", oDao.getPropertiesMetaData());
                oReplyBean = new ReplyBeanHelper(200, GsonHelper.getGson().toJson(alMeta));
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    @Override
    public ReplyBeanHelper getObjectMetaData() throws Exception {
        ReplyBeanHelper oReplyBean = null;
        if (this.checkPermission("getObjectMetaData")) {
            String data = null;
            try {
                MetaDaoInterface oDao = DaoFactory.getDao(ob, null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                String strJson = GsonHelper.getGson().toJson(oDao.getObjectMetaData());
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

    @Override
    public ReplyBeanHelper getPropertiesMetaData() throws Exception {
        ReplyBeanHelper oReplyBean = null;
        if (this.checkPermission("getPropertiesMetaData")) {
            String data = null;
            try {
                MetaDaoInterface oDao = DaoFactory.getDao(ob, null, (MetaBeanHelper) oRequest.getSession().getAttribute("user"), null);
                String strJson = GsonHelper.getGson().toJson(oDao.getPropertiesMetaData());
                oReplyBean = new ReplyBeanHelper(200, strJson);
            } catch (Exception ex) {
                String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
                Log4jHelper.errorLog(msg, ex);
                throw new Exception(msg, ex);
            }
            return oReplyBean;
        } else {
            return new ReplyBeanHelper(401, EncodingHelper.quotate("Unauthorized"));
        }
    }

}
