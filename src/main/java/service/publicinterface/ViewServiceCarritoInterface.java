package service.publicinterface;

import bean.specificimplementation.ReplybeanSpecificImplementation;

public interface ViewServiceCarritoInterface {

    public ReplybeanSpecificImplementation list() throws Exception;

    public ReplybeanSpecificImplementation buy() throws Exception;

    public ReplybeanSpecificImplementation empty() throws Exception;
}
