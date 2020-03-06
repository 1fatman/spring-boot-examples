package com.dq.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dq.entity.User;
import com.dq.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/6
 * @Description: TODO
 */
@SpringBootTest
public class TestUser {

    @Resource
    private UserMapper userMapper;

    @Test
    void testAddUser() {
        User user = new User();
        user.setName("群众");
        user.setAge(24);
        int res = userMapper.insert(user);
        if (res > 0) {
            System.out.println(user);
        }
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        user.setId(2);
        user.setName("大泉");
        user.setAge(22);
        int res = userMapper.updateById(user);
        if (res > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("ERROR");
        }
    }

    @Test
    void testSelUser() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    void testDelUser() {
        int res = userMapper.deleteById(1);
        if (res > 0) {
            System.out.println("TRUE");
        } else {
            System.out.println("ERROR");
        }
    }

    @Test
    void TestConditionQuery() {
        QueryWrapper<User> wrapper = new QueryWrapper();
        // like 会在字符的前后默认添加%
        wrapper.like("name", "泉");
        wrapper.eq("age", 24);
        int delete = userMapper.delete(wrapper);
        if (delete > 0) {
            System.out.println("TRUE");
        } else {
            System.out.println("ERROR");
        }
    }
}
