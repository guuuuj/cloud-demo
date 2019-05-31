package cn.itcast.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
//配合通用sql
@Table(name = "tb_user")
public class User {

    //代表为主键
    @Id
    //主键自增
    @KeySql(useGeneratedKeys = true)
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
    @Transient
    private String note;


}
