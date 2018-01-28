/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.publicinterface;

import bean.genericimplementation.TableGenericBeanImplementation;
import bean.helper.MetaBeanHelper;

public interface TableDaoInterface extends ViewDaoInterface {

    public MetaBeanHelper get(int id, int intExpand) throws Exception;

    public Integer set(TableGenericBeanImplementation oBean) throws Exception;

    public int remove(Integer id) throws Exception;

}
