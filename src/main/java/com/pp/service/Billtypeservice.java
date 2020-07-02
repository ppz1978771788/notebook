package com.pp.service;

import com.pp.pojo.Billtype;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pp
 * @since 2020-05-30
 */
public interface Billtypeservice {
    public List<Billtype> FindAll();

    Billtype getById(Integer id);

}
