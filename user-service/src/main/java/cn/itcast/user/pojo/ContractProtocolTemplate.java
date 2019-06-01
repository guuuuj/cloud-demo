package cn.itcast.user.pojo;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Table(name = "contract_protocol_template")
public class ContractProtocolTemplate {

    //协议模板ID
    @Id
    private String templateId;

    //协议类型：[EnumProtocolTemplateType]
    private String type;

    //协议名称
    private String name;

    //状态：[EnumProtocolTemplateStatus]
    private String status;

    //内容
    private String content;

    //创建时间
    private Timestamp createTime;

    //修改时间
    private Timestamp updateTime;

    //租户ID
    @Id
    private String tenantId;

    //终端：[参考枚举：EnumTerminalType]
    private String terminal;
}
