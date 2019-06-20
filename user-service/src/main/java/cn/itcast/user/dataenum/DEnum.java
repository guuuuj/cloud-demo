package cn.itcast.user.dataenum;

/**
 * @Description TODO
 * @Author G.J.
 **/
public enum DEnum {
    GUOQIN("2019-01-01", "2"),
    ZHONGQIU("2019-02-02", "2");

    private String code;

    private String desc;

    private DEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
