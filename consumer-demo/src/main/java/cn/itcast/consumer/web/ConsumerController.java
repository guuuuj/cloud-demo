package cn.itcast.consumer.web;

import cn.itcast.consumer.client.UserClient;
import cn.itcast.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

    //@Autowired
    //private RibbonLoadBalancerClient ribbonLoadBalancerClient;

    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userClient.queryById(id);
    }

    //@GetMapping("/{id}")
    //@HystrixCommand(fallbackMethod = "queryByIdFallback")
    //自定义超时时长，默认为1s
    /*@HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })*/
    /*@HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
            }
    )
    public String queryById(@PathVariable("id") Long id) {
        if (id % 2 == 0) {
            throw new RuntimeException("");
        }
        String url = "http://user-service/user/" + id;
        String user = restTemplate.getForObject(url, String.class);
        return user;
    }*/

    //针对某方法的失败返回，参数和返回类型都得一致
    public String queryByIdFallback(Long id) {
        return "不好意思，服务器拥挤！";
    }

    //默认返回错误方法，参数为空
    public String defaultFallback() {
        return "不好意思，服务器拥挤！";
    }


    /*@GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        //根据服务id获取实例
        //List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //从实例中取出ip和端口
        //ServiceInstance instance = instances.get(0);

        //随机，轮询，hash   ribbon负载均衡，默认为轮询
//        ServiceInstance instance = ribbonLoadBalancerClient.choose("user-service");
//        String url = "http://"+instance.getHost() + ":" + instance.getPort() +"/user/" + id;

        String url = "http://user-service/user/" + id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }*/
}
