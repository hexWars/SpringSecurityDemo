package top.sehnsucht.springsecuritydemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public void TestBCryptPasswordEncoder () {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("sq0828");
        String encode2 = bCryptPasswordEncoder.encode("sq0828");
        System.out.println(encode);
        System.out.println(encode2);
        System.out.println(bCryptPasswordEncoder.matches("sq0828", encode));
    }

    @Test
    public void testUserMapper() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
