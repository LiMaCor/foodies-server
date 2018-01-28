package bean.meta.helper;

import com.google.gson.annotations.Expose;
import helper.EnumHelper;

public class MetaObjectGenericBeanHelper {

    private String ClassName = "";
    @Expose
    private String Icon = "";
    @Expose
    private String SingularDescription = "";
    @Expose
    private String PluralDescription = "";
    @Expose
    private EnumHelper.SourceType Type = EnumHelper.SourceType.Table;
    @Expose
    private String TableName = "";

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String CName) {
        this.ClassName = CName;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String Icon) {
        this.Icon = Icon;
    }

    public String getSingularDescription() {
        return SingularDescription;
    }

    public void setSingularDescription(String SingularDescription) {
        this.SingularDescription = SingularDescription;
    }

    public String getPluralDescription() {
        return PluralDescription;
    }

    public void setPluralDescription(String PluralDescription) {
        this.PluralDescription = PluralDescription;
    }

    public EnumHelper.SourceType getType() {
        return Type;
    }

    public void setType(EnumHelper.SourceType Type) {
        this.Type = Type;
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String TableName) {
        this.TableName = TableName;
    }

}
