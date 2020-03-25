package com.dq.redis;

import com.dq.entity.User;
import com.dq.utils.CacheTime;
import com.dq.utils.RedisClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/6
 * @Description: TODO
 */
@SpringBootTest
public class TestRedisClient {

    @Resource
    private RedisClient redisClient;

    @Test
    void testRedisClient() {
        User user = new User();
        user.setId(3);
        user.setName("二嬢");
        user.setAge(22);
        redisClient.set("user:3", user, 0);
    }

    @Test
    void testGetUser() {
        User user = (User) redisClient.get("user:3");
        System.out.println(user);
    }


    /**
     * 随机生成一个6位数的验证码
     *
     * @return
     */
    final static String randomCode() {
        Random random = new Random();
        int len = 6;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            res.append(random.nextInt(10));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String randomCode = randomCode();
        System.out.println(randomCode);
    }

    @Test
    void testSetCode() {
        redisClient.set("user:2:code", randomCode(), CacheTime.CACHE_EXP_MINUTE);
        Object o = redisClient.get("user:2:code");
        System.out.println(o.toString());
    }

    @Test
    void testGetCode() {
        String code = (String) redisClient.get("user:2:code");
        if (code == null) {
            System.out.println("验证码错误");
        } else {
            System.out.println("true");
        }
    }
}
