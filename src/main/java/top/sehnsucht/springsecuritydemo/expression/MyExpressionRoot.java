package top.sehnsucht.springsecuritydemo.expression;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import top.sehnsucht.springsecuritydemo.entity.LoginUser;

import java.util.List;

/**
 * @Description:
 * @Author: Cai
 * @CreateTime: 2022/8/8
 */
//@Component("ex")
public class MyExpressionRoot {
    public boolean hasAuthority(String authority) {
        // 测试是否通过
        System.out.println("MyExpression is normal!");
        // 获取当前用户的权限
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) auth.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        // 判断用户权限集合中是否存在authority
        return permissions.contains(authority);
    }
}
