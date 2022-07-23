package top.sehnsucht.springsecuritydemo.service.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import top.sehnsucht.springsecuritydemo.entity.LoginUser;
import top.sehnsucht.springsecuritydemo.entity.User;
import top.sehnsucht.springsecuritydemo.service.LoginService;
import top.sehnsucht.springsecuritydemo.utils.JwtUtil;
import top.sehnsucht.springsecuritydemo.utils.RedisCache;
import top.sehnsucht.springsecuritydemo.vo.ResponseResult;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description:
 * @Author: Cai
 * @CreateTime: 2022/7/22
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult login(User user) {
        // 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 如果没通过给出提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        // 如果通过生成jwt
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);
        // 把完整用户信息存入redis,userid作为key
        redisCache.setCacheObject("login:" + userid, loginUser);
        return new ResponseResult(200, "登录成功", map);
    }
}