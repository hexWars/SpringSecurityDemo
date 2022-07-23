package top.sehnsucht.springsecuritydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.sehnsucht.springsecuritydemo.entity.User;
import top.sehnsucht.springsecuritydemo.service.LoginService;
import top.sehnsucht.springsecuritydemo.vo.ResponseResult;

/**
 * @Description:
 * @Author: Cai
 * @CreateTime: 2022/7/17
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/user/login")
    public ResponseResult testMapping(@RequestBody User user) {
        return loginService.login(user);
    }
}
