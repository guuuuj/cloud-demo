package cn.itcast.user.web;

import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@Slf4j
@RestController
@RequestMapping("user")
public class HelloController {

    /*@Autowired
    private DataSource dataSource;*/

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    //@ResponseBody
    public User hello(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
