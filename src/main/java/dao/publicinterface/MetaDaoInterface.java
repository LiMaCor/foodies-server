/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.publicinterface;

import bean.meta.helper.MetaObjectGenericBeanHelper;
import bean.meta.helper.MetaPropertyGenericBeanHelper;
import java.util.ArrayList;

public interface MetaDaoInterface {

    public MetaObjectGenericBeanHelper getObjectMetaData() throws Exception;

    public ArrayList<MetaPropertyGenericBeanHelper> getPropertiesMetaData() throws Exception;
}
