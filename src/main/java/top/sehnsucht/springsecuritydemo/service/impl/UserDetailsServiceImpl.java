package top.sehnsucht.springsecuritydemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;
import top.sehnsucht.springsecuritydemo.entity.LoginUser;
import top.sehnsucht.springsecuritydemo.entity.User;
import top.sehnsucht.springsecuritydemo.mapper.UserMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: Cai
 * @CreateTime: 2022/7/22
 */
@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        User user = userMapper.selectOne(queryWrapper);
        // 如果没有查询到用户
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名或者密码错误");
        }
        // 查询对应的权限信息
        List<String> list = new ArrayList<>(Arrays.asList("admin", "common"));
        // 把数据封装成UserDetails
        return new LoginUser(user, list);
    }
}
