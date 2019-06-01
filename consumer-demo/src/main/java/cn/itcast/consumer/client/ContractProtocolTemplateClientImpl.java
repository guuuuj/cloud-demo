package cn.itcast.consumer.client;

import cn.itcast.consumer.pojo.ContractProtocolTemplate;
import org.springframework.stereotype.Component;

@Component
public class ContractProtocolTemplateClientImpl implements ContractProtocolTemplateClient {
    @Override
    public ContractProtocolTemplate queryContract(String templateId) {
        ContractProtocolTemplate contractProtocolTemplate = new ContractProtocolTemplate();
        contractProtocolTemplate.setContent("未知");
        return contractProtocolTemplate;
    }
}
