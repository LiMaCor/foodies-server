package bean.helper;

import com.google.gson.annotations.Expose;
import bean.genericimplementation.TableGenericBeanImplementation;
import bean.meta.helper.MetaObjectGenericBeanHelper;
import bean.meta.helper.MetaPropertyGenericBeanHelper;
import java.util.ArrayList;

public class MetaBeanHelper {

    @Expose
    private ArrayList<MetaPropertyGenericBeanHelper> metaProperties;
    @Expose
    private MetaObjectGenericBeanHelper metaObject;
    @Expose
    private Object data;

    public MetaBeanHelper() {
    }

    public MetaBeanHelper(MetaObjectGenericBeanHelper oMetaObject, ArrayList<MetaPropertyGenericBeanHelper> alMetaProperties, Object oBean) {

        this.metaProperties = alMetaProperties;
        this.metaObject = oMetaObject;
        this.data = oBean;
    }

    public ArrayList<MetaPropertyGenericBeanHelper> getMetaProperties() {
        return metaProperties;
    }

    public void setMetaProperties(ArrayList<MetaPropertyGenericBeanHelper> metaProperties) {
        this.metaProperties = metaProperties;
    }

    public MetaObjectGenericBeanHelper getMetaObject() {
        return metaObject;
    }

    public void setMetaObject(MetaObjectGenericBeanHelper metaObject) {
        this.metaObject = metaObject;
    }

    public Object getBean() {
        return data;
    }

    public void setBean(TableGenericBeanImplementation bean) {
        this.data = bean;
    }

}
