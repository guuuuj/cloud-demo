package cn.itcast.user.service;

import cn.itcast.user.mapper.ContractProtocolTemplateMapper;
import cn.itcast.user.pojo.ContractProtocolTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractProtocolTemplateService {

    @Autowired
    private ContractProtocolTemplateMapper contractProtocolTemplateMapper;

    public ContractProtocolTemplate queryContract(String templateId) {
        ContractProtocolTemplate c = new ContractProtocolTemplate();
        c.setTemplateId(templateId);
        ContractProtocolTemplate contractProtocolTemplate = contractProtocolTemplateMapper.selectOne(c);
        return contractProtocolTemplate;
    }

    /*public Object contract(){
        queryContract().getContent();
    }*/
}
