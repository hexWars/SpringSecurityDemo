package top.sehnsucht.springsecuritydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.sehnsucht.springsecuritydemo.entity.User;
import top.sehnsucht.springsecuritydemo.service.LoginService;
import top.sehnsucht.springsecuritydemo.entity.ResponseResult;

/**
 * @Description:
 * @Author: Cai
 * @CreateTime: 2022/7/17
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/test")
    public ResponseResult test() {
        return new ResponseResult(200, "test");
    }
    @PreAuthorize("hasAnyAuthority('user:test')")
    @PostMapping("/auth")
    public ResponseResult authTest() {
        return new ResponseResult(200, "authTest");
    }

    @PreAuthorize("hasAnyAuthority('user:test2')")
    @PostMapping("/auth2")
    public ResponseResult authTest2() {
        return new ResponseResult(200, "authTest222");
    }
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        return loginService.login(user);
    }
    @RequestMapping("/logout")
    public ResponseResult logout() {
        return loginService.logout();
    }
}
