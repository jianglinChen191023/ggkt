package com.atguigu;

import com.atguigu.entity.User;
import com.atguigu.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class GgktMpDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    /**
     * 查询所有用户
     */
    @Test
    public void findAll() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::print);
    }

    /**
     * 添加用户
     */
    @Test
    public void addUser() {
        User user = new User(null, "尚硅谷", 9, "atguigu.com", 0);
        int rows = userMapper.insert(user);
        System.out.println("rows:" + rows);
        // 添加成功后, 把添加之后生成的 id 值, 回填到 user 对象中
        System.out.println(user);
    }

    /**
     * 根据 Id 修改
     */
    @Test
    public void testUpdateById() {
        // 1 根据 id 查询记录
        User user = userMapper.selectById(1572834755096702978L);

        // 2 设置修改的值
        user.setAge(18);

        // 3 调用方法修改
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    /**
     * 分页查询
     */
    @Test
    public void findPage() {
        // 创建配置对象, 传递两个参数: 当前页 每页显示记录数
        Page<User> page = new Page<>(1, 3);
        // 调用 MP 方法实现分页
        userMapper.selectPage(page, null);
        // IPage<User> pageModel = userMapper.selectPage(page, null);
        List<User> list = page.getRecords();
        System.out.println(list);

        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    /**
     * 根据 Id 删除
     */
    @Test
    public void deleteByIdeById() {
        userMapper.deleteById(1577034147517198337L);
    }

    /**
     * 批量删除
     */
    @Test
    public void deleteBatch() {
        int rows = userMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(rows);
    }

    /**
     * QueryWrapper 使用
     */
    @Test
    public void testSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 18);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /**
     * LambdaQueryWrapper 使用
     */
    @Test
    public void testLambdaQuery() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAge, 30);
        queryWrapper.like(User::getName, "张");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

}
