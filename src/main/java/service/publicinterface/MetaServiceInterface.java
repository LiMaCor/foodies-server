package service.publicinterface;

import bean.helper.ReplyBeanHelper;

public interface MetaServiceInterface {

    public ReplyBeanHelper getMetaData() throws Exception;

    public ReplyBeanHelper getObjectMetaData() throws Exception;

    public ReplyBeanHelper getPropertiesMetaData() throws Exception;

}
