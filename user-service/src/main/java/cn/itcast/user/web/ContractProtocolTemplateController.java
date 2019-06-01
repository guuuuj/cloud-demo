package cn.itcast.user.web;

import cn.itcast.user.pojo.ContractProtocolTemplate;
import cn.itcast.user.service.ContractProtocolTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("contract")
public class ContractProtocolTemplateController {

    @Autowired
    ContractProtocolTemplateService contractProtocolTemplateService;

    @GetMapping("/template")
    public ContractProtocolTemplate queryContract(@RequestParam("templateId") String templateId){
        ContractProtocolTemplate contractProtocolTemplate = contractProtocolTemplateService.queryContract(templateId);
        return contractProtocolTemplate;
    }
}
