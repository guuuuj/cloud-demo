package cn.itcast.consumer.client;

import cn.itcast.consumer.pojo.ContractProtocolTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service",fallback = ContractProtocolTemplateClientImpl.class)
public interface ContractProtocolTemplateClient {

    @GetMapping("contract/template")
    ContractProtocolTemplate queryContract(@RequestParam("templateId") String templateId);
}
