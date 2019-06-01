package cn.itcast.consumer.web;

import cn.itcast.consumer.client.ContractProtocolTemplateClient;
import cn.itcast.consumer.pojo.ContractProtocolTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contract")
@DefaultProperties(defaultFallback = "defaultFallback")
public class ContractConsumerController {

    @Autowired
    ContractProtocolTemplateClient contractProtocolTemplateClient;

    @GetMapping("/templateId")
    public ContractProtocolTemplate query(@RequestParam("templateId") String templateId){
        ContractProtocolTemplate contractProtocol = contractProtocolTemplateClient.queryContract(templateId);
        return contractProtocol;
    }

    //默认返回错误方法，参数为空
    public String defaultFallback() {
        return "不好意思，服务器拥挤！";
    }

}
