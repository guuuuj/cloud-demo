package cn.itcast.consumer.pojo;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class ContractProtocolTemplate {

    //协议模板ID
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
    private String tenantId;

    //终端：[参考枚举：EnumTerminalType]
    private String terminal;
}
