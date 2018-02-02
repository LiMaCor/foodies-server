package service.publicinterface;

import bean.specificimplementation.ReplybeanSpecificImplementation;


public interface TableServiceCarritoInterface {

    public ReplybeanSpecificImplementation add() throws Exception;

    public ReplybeanSpecificImplementation remove() throws Exception;
}
