package cn.itcast.user.service;

import cn.itcast.user.pojo.ContractProtocolTemplate;
import cn.itcast.user.util.Util;

import java.util.Map;

/**
 * @Description TODO
 * @Author G.J.
 **/
public class TestObjToMap {

    public static void main(String[] args) {
        ContractProtocolTemplate contractProtocolTemplate = new ContractProtocolTemplate();
        contractProtocolTemplate.setType("1");
        contractProtocolTemplate.setName("2");
        Map<String,Object> map = Util.transBean2Map(contractProtocolTemplate);
        System.out.println(map);
    }
}
