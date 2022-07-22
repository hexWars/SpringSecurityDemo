package top.sehnsucht.springsecuritydemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.sehnsucht.springsecuritydemo.entity.User;
import top.sehnsucht.springsecuritydemo.mapper.UserMapper;

import java.util.List;

/**
 * @Description:
 * @Author: Cai
 * @CreateTime: 2022/7/22
 */
@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testUserMapper() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
