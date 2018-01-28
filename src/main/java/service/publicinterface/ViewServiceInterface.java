package service.publicinterface;

import bean.helper.ReplyBeanHelper;

public interface ViewServiceInterface {

    public ReplyBeanHelper getPage() throws Exception;

    public ReplyBeanHelper getCount() throws Exception;

    public ReplyBeanHelper getPageX() throws Exception;

    public ReplyBeanHelper getCountX() throws Exception;

}
