package com.pp.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pp.pojo.User;
import com.pp.mapper.UserMapper;
import com.pp.service.Userservice;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pp
 * @since 2020-05-30
 */
@Service
public class UserServiceImpl implements Userservice {
@Autowired
private UserMapper userMapper;
    @Override
    public User FindUser(String loginname, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("loginname",loginname).eq("pwd",password);
        User user = userMapper.selectOne(wrapper);
        return user;
    }
}
