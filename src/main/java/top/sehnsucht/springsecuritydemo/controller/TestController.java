package top.sehnsucht.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Cai
 * @CreateTime: 2022/7/17
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String testMapping() {
        return "test";
    }
}
