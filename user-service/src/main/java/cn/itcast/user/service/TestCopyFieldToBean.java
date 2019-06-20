package cn.itcast.user.service;

import cn.itcast.user.pojo.ContractProtocolTemplate;
import cn.itcast.user.pojo.TestPojo;
import cn.itcast.user.util.Util;

import java.lang.reflect.Field;

/**
 * @Description TODO
 * @Author G.J.
 **/
public class TestCopyFieldToBean {
    public static void main(String[] args) {

        ContractProtocolTemplate contractProtocolTemplate = new ContractProtocolTemplate();
        TestPojo testPojo = new TestPojo();

        contractProtocolTemplate.setType("111111");
        //contractProtocolTemplate.setName("张三");

        Util.copyFieldToBean(contractProtocolTemplate, testPojo);
        testPojo.setName("lalalal");
        Field[] fds = testPojo.getClass().getDeclaredFields();
        for (Field fd : fds) {
            try {
                fd.setAccessible(true);
                System.out.println(fd.getName() + "=" + fd.get(testPojo));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
