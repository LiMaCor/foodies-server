package bean.genericimplementation;

import bean.helper.MetaBeanHelper;
import bean.meta.publicinterface.MetaObjectBeanInterface;
import bean.meta.publicinterface.MetaPropertyBeanInterface;
import java.sql.Connection;
import java.sql.ResultSet;
import bean.publicinterface.GenericBeanInterface;
import dao.publicinterface.TableDaoInterface;
import factory.DaoFactory;
import helper.EnumHelper.FieldType;
import helper.Log4jHelper;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;

public abstract class ViewGenericBeanImplementation implements GenericBeanInterface {

    public ViewGenericBeanImplementation() {

    }

    private String getOwnNameFromObjectMetaData() {
        String strOwnTable = "";
        Annotation[] classAnnotations = this.getClass().getAnnotationsByType(MetaObjectBeanInterface.class);
        for (Integer i = 0; i < classAnnotations.length; i++) {
            if (classAnnotations[i].annotationType().equals(MetaObjectBeanInterface.class)) {
                MetaObjectBeanInterface fieldAnnotation = (MetaObjectBeanInterface) classAnnotations[i];
                strOwnTable = fieldAnnotation.TableName();
            }
        }
        return strOwnTable;
    }

    protected FieldType getTypeFromPropertyMetaData(Field field) {
        FieldType f = null;
        Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
        for (Integer i = 0; i < fieldAnnotations.length; i++) {
            if (fieldAnnotations[i].annotationType().equals(MetaPropertyBeanInterface.class)) {
                MetaPropertyBeanInterface fieldAnnotation = (MetaPropertyBeanInterface) fieldAnnotations[i];
                f = fieldAnnotation.Type();
            }
        }
        return f;
    }

    private String getReferencesFromPropertyMetaData(Field field) {
        String f = null;
        Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
        for (Integer i = 0; i < fieldAnnotations.length; i++) {
            if (fieldAnnotations[i].annotationType().equals(MetaPropertyBeanInterface.class)) {
                MetaPropertyBeanInterface fieldAnnotation = (MetaPropertyBeanInterface) fieldAnnotations[i];
                f = fieldAnnotation.References();
            }
        }
        return f;
    }

    @Override
    public GenericBeanInterface fill(ResultSet oResultSet, Connection oConnection, MetaBeanHelper oPuserBean_security, Integer expand) throws Exception {
        try {
            ViewGenericBeanImplementation oBean = (ViewGenericBeanImplementation) Class.forName(this.getClass().getName()).newInstance();
            if (this.getClass().getSuperclass() == TableGenericBeanImplementation.class) {
                Field x = this.getClass().getSuperclass().getDeclaredField("id");
                x.setAccessible(true);
                x.set(this, oResultSet.getInt("id"));
                x.setAccessible(false);
            }
            Field[] oFields = oBean.getClass().getDeclaredFields();
            for (Field x : oFields) {
                x.setAccessible(true);
                if (getTypeFromPropertyMetaData(x) != null) {
                    if (getTypeFromPropertyMetaData(x) != FieldType.Calculated) {
                        if (getTypeFromPropertyMetaData(x) == FieldType.ForeignObject) {
                            if (expand > 0) {
                                String ob = getReferencesFromPropertyMetaData(x);
                                TableDaoInterface oObDao = (TableDaoInterface) DaoFactory.getDao(ob, oConnection, oPuserBean_security, null);
                                MetaBeanHelper oMetaBeanHelper = (MetaBeanHelper) oObDao.get(oResultSet.getInt("id_" + ob), expand - 1);
                                x.set(this, oMetaBeanHelper);
                            }
                        } else {
                            if (getTypeFromPropertyMetaData(x) == FieldType.Link) {
                                String ob = getReferencesFromPropertyMetaData(x);
                                TableDaoInterface oObDao = (TableDaoInterface) DaoFactory.getDao(ob, oConnection, oPuserBean_security, " and id_" + getOwnNameFromObjectMetaData() + "=" + oResultSet.getInt("id"));
                                if (oObDao != null) { //en el proceso de login puede ser nulo!!
                                    x.set(this, oObDao.getCount(null).intValue());
                                } else {
                                    x.set(this, 0);
                                }
                            } else {
                                if (getTypeFromPropertyMetaData(x) == FieldType.ForeignId) {
                                    x.set(this, oResultSet.getInt(x.getName()));
                                } else {
                                    if (x.getType() == String.class) {
                                        x.set(this, oResultSet.getString(x.getName()));
                                    } else {
                                        if (x.getType() == Date.class) {
                                            x.set(this, oResultSet.getDate(x.getName()));
                                        } else {
                                            if (x.getType() == Double.class || x.getType() == double.class) {
                                                x.set(this, oResultSet.getDouble(x.getName()));
                                            } else {
                                                if (x.getType() == Integer.class || x.getType() == int.class) {
                                                    x.set(this, oResultSet.getInt(x.getName()));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                x.setAccessible(false);
            }

            this.ComputeCalculatedFields();

        } catch (Exception ex) {
            String msg = this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName();
            Log4jHelper.errorLog(msg, ex);
            throw new Exception(msg, ex);
        }
        return this;
    }

    @Override
    public void ComputeCalculatedFields() {

    }
}
