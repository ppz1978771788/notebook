package com.pp.mapper;

import com.pp.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pp
 * @since 2020-05-30
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
