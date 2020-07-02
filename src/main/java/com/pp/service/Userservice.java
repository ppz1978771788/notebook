package com.pp.service;

import com.pp.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pp
 * @since 2020-05-30
 */
public interface Userservice {
    User FindUser(String loginname,String password);

}
