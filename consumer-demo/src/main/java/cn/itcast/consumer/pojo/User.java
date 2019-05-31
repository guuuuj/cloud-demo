package cn.itcast.consumer.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {


    private Long id;
    private String userName;
    private String passWord;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private Date created;
    private Date updated;
    //若不是当前表的字段 可以用这个注解
    private String note;


}
