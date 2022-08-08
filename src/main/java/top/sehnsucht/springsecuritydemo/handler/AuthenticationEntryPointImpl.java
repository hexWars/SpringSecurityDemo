package top.sehnsucht.springsecuritydemo.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import top.sehnsucht.springsecuritydemo.entity.ResponseResult;
import top.sehnsucht.springsecuritydemo.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: Cai
 * @CreateTime: 2022/8/8
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "用户认证失败,请重新登录");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
