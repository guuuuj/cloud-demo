package cn.itcast.user.pojo;

import lombok.Data;

import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author G.J.
 **/
@Data
public class TestPojo {

    //协议类型：[EnumProtocolTemplateType]
    private String type;

    //协议名称
    private String name;


}
