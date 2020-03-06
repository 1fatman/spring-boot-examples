package com.dq.redis;

import com.dq.entity.User;
import com.dq.utils.CacheTime;
import com.dq.utils.RedisClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/5
 * @Description: TODO
 */
@Slf4j
@SpringBootTest
public class TestRedisTemplate {

    @Resource
    private RedisClient redisClient;

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void testRedisConn() {
        User user = new User();
        user.setId(1);
        user.setName("刘清泉");
        user.setAge(24);
        boolean res = redisClient.set("user:1", user, CacheTime.CACHE_EXP_FIVE_SECONDS);
        if (res) {
            System.out.println("OK!");
        } else {
            System.out.println("ERROR!");
        }
    }

    @Test
    void testGetUser() {
        User user = (User) redisClient.get("user:1");
        System.out.println(user.toString());
    }

    @Test
    void testRedisTemplate() {
        User user = new User();
        user.setId(1);
        user.setName("刘清泉");
        user.setAge(24);
        redisTemplate.opsForValue().set("user:1", user);
    }

    @Test
    void testJedisTemplate() {
        User user = new User();
        user.setId(2);
        user.setName("大泉");
        user.setAge(24);
        redisClient.set("user:2", user, 0);
        // redisTemplate.opsForValue().set("user:2", user, CacheTime.CACHE_EXP_FIVE_MINUTES);
    }

    @Test
    void testGetUser2() {
        User user = (User) redisClient.get("user:2");
        // User user = (User) redisTemplate.opsForValue().get("user:2");
        System.out.println(user);
    }

    @Test
    void testDelUser() {
        redisTemplate.delete("user:2");
    }
}
