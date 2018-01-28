/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.genericimplementation;

import bean.meta.publicinterface.MetaPropertyBeanInterface;
import bean.meta.helper.MetaObjectGenericBeanHelper;
import bean.meta.helper.MetaPropertyGenericBeanHelper;
import bean.genericimplementation.ViewGenericBeanImplementation;
import bean.helper.MetaBeanHelper;
import bean.meta.publicinterface.MetaObjectBeanInterface;
import dao.publicinterface.MetaDaoInterface;
import helper.Log4jHelper;
import factory.BeanFactory;
import helper.EnumHelper;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class MetaGenericDaoImplementation implements MetaDaoInterface {

    protected String ob = null;
    protected String strSQL = null;
    protected String strCountSQL = null;
    protected Connection oConnection = null;
    protected MetaBeanHelper oPuserSecurity = null;

    public MetaGenericDaoImplementation(String obj, Connection oPooledConnection, MetaBeanHelper oPuserBean_security, String strWhere) throws Exception {
        oConnection = oPooledConnection;
        oPuserSecurity = oPuserBean_security;
        ob = obj;
        try {
            strSQL = "SELECT * FROM " + ob + " WHERE 1=1 ";
            strCountSQL = "SELECT COUNT(*) FROM " + ob + " WHERE 1=1 ";
            if (strWhere != null) {
                strSQL += " " + strWhere + " ";
                strCountSQL += " " + strWhere + " ";
            }
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
    }

    private ArrayList<MetaPropertyGenericBeanHelper> fillPropertiesMetaData(Class oClassBEAN, ArrayList<MetaPropertyGenericBeanHelper> alVector) {
        for (Field field : oClassBEAN.getDeclaredFields()) {
            Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
            for (Integer i = 0; i < fieldAnnotations.length; i++) {
                if (fieldAnnotations[i].annotationType().equals(MetaPropertyBeanInterface.class)) {
                    MetaPropertyBeanInterface fieldAnnotation = (MetaPropertyBeanInterface) fieldAnnotations[i];
                    if (fieldAnnotation.Type() != EnumHelper.FieldType.Password
                            && fieldAnnotation.Type() != EnumHelper.FieldType.Token
                            && fieldAnnotation.Type() != EnumHelper.FieldType.ForeignId) {
                        MetaPropertyGenericBeanHelper oMeta = new MetaPropertyGenericBeanHelper();
                        oMeta.setName(field.getName());
                        oMeta.setShortName(fieldAnnotation.ShortName());
                        oMeta.setLongName(fieldAnnotation.LongName());
                        oMeta.setDescription(fieldAnnotation.Description());
                        oMeta.setIsId(field.getName() == "id");
                        oMeta.setIsIdForeignKey(field.getName().startsWith("id_"));
                        oMeta.setIsObjForeignKey(field.getName().startsWith("obj_"));
                        oMeta.setReferences(fieldAnnotation.References());
                        oMeta.setIsForeignKeyDescriptor(fieldAnnotation.IsForeignKeyDescriptor());
                        oMeta.setType(fieldAnnotation.Type());
                        oMeta.setIsRequired(fieldAnnotation.IsRequired());
                        oMeta.setRegexPattern(fieldAnnotation.RegexPattern());
                        oMeta.setRegexHelp(fieldAnnotation.RegexHelp());
                        oMeta.setDefaultValue(fieldAnnotation.DefaultValue());
                        oMeta.setIsVisible(fieldAnnotation.IsVisible());
                        oMeta.setWidth(fieldAnnotation.Width());
                        oMeta.setMaxLength(fieldAnnotation.MaxLength());
                        alVector.add(oMeta);
                    }
                }
            }
        }
        return alVector;
    }

    private MetaObjectGenericBeanHelper fillObjectMetaData(Class oClassBEAN, MetaObjectGenericBeanHelper oMetaObject) {
        Annotation[] classAnnotations = oClassBEAN.getAnnotations();
        for (Integer i = 0; i < classAnnotations.length; i++) {
            if (classAnnotations[i].annotationType().equals(MetaObjectBeanInterface.class)) {
                MetaObjectBeanInterface fieldAnnotation = (MetaObjectBeanInterface) classAnnotations[i];
                oMetaObject.setClassName(oClassBEAN.getName());
                oMetaObject.setSingularDescription(fieldAnnotation.SingularDescription());
                oMetaObject.setPluralDescription(fieldAnnotation.PluralDescription());
                oMetaObject.setIcon(fieldAnnotation.Icon());
                oMetaObject.setTableName(fieldAnnotation.TableName());
                oMetaObject.setType(fieldAnnotation.Type());
            }
        }
        return oMetaObject;
    }

    @Override
    public MetaObjectGenericBeanHelper getObjectMetaData() throws Exception {
        MetaObjectGenericBeanHelper oMetaObject;
        try {
            ViewGenericBeanImplementation oBean = (ViewGenericBeanImplementation) BeanFactory.getBean(ob, oPuserSecurity);
            Class oClassBEAN = oBean.getClass();
            oMetaObject = new MetaObjectGenericBeanHelper();
            oMetaObject = fillObjectMetaData(oClassBEAN, oMetaObject);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return oMetaObject;
    }

    @Override
    public ArrayList<MetaPropertyGenericBeanHelper> getPropertiesMetaData() throws Exception {
        ArrayList<MetaPropertyGenericBeanHelper> alVector = new ArrayList<>();
        try {
            ViewGenericBeanImplementation oBean = (ViewGenericBeanImplementation) BeanFactory.getBean(ob, oPuserSecurity);
            Class classBean = oBean.getClass();
            Class superClassBean = oBean.getClass().getSuperclass();
            alVector = fillPropertiesMetaData(superClassBean, alVector);
            alVector = fillPropertiesMetaData(classBean, alVector);
        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName() + " ob:" + ob;
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return alVector;
    }

}

