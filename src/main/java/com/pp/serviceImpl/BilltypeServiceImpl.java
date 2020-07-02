package com.pp.serviceImpl;

import com.pp.pojo.Billtype;
import com.pp.mapper.BilltypeMapper;
import com.pp.service.Billtypeservice;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pp
 * @since 2020-05-30
 */
@Service
public class BilltypeServiceImpl  implements Billtypeservice {
    @Autowired
    private BilltypeMapper billtypeMapper;


    @Override
    public List<Billtype> FindAll() {
        return billtypeMapper.selectList(null);
    }

    @Override
    public Billtype getById(Integer id) {
        return billtypeMapper.selectById(id);
    }
}
