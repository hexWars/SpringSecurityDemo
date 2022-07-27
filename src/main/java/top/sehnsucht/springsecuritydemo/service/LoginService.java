package top.sehnsucht.springsecuritydemo.service;

import top.sehnsucht.springsecuritydemo.entity.User;
import top.sehnsucht.springsecuritydemo.entity.ResponseResult;

/**
 * @Description:
 * @Author: Cai
 * @CreateTime: 2022/7/22
 */

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
