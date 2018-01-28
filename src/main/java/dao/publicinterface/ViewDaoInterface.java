package dao.publicinterface;

import bean.helper.FilterBeanHelper;
import bean.helper.MetaBeanHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface ViewDaoInterface extends MetaDaoInterface {

    public Long getCount(ArrayList<FilterBeanHelper> alFilter) throws Exception;

    public MetaBeanHelper getPage(int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception;

    public MetaBeanHelper getPageX(int id_foreign, String ob_foreign, int intRegsPerPag, int intPage, LinkedHashMap<String, String> hmOrder, ArrayList<FilterBeanHelper> alFilter, int expand) throws Exception;

    public Long getCountX(int id_foreign, String ob_foreign, ArrayList<FilterBeanHelper> alFilter) throws Exception;

}
