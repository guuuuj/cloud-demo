package cn.itcast.user.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author G.J.
 **/
@Data
@Component
public class OcrConf {

    @Value("${conf.upload}")
    private String upload;

    @Value("${conf.token}")
    private String token;

}
