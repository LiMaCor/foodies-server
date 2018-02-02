package bean.specificimplementation;


public class ReplybeanSpecificImplementation {

    private Integer code;
    private String json;

    public ReplybeanSpecificImplementation(Integer code, String json) {
        this.code = code;
        this.json = json;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

}
