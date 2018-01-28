/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.publicinterface;

import bean.helper.ReplyBeanHelper;

public interface TableServiceInterface {

    public ReplyBeanHelper get() throws Exception;

    public ReplyBeanHelper set() throws Exception;

    public ReplyBeanHelper remove() throws Exception;

}
