package com.pp.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pp.pojo.Bills;
import com.pp.mapper.BillsMapper;
import com.pp.pojo.BillsVo;
import com.pp.service.Billsservice;
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
public class BillsServiceImpl  implements Billsservice {
    @Autowired
    private BillsMapper billsMapper;

    @Override
    public IPage<Bills> FindAllBills(BillsVo billsVo) {
        System.out.println("分页的条数"+billsVo.getLimit());
        System.out.println("分页的页数"+billsVo.getPage());
        IPage<Bills> page=new Page<>(billsVo.getPage(),billsVo.getLimit());
        QueryWrapper<Bills> wrapper = new QueryWrapper<>();
        wrapper.eq(null!=billsVo.getTypeid()&&billsVo.getTypeid()!=0,"typeid",billsVo.getTypeid());
        wrapper.ge(billsVo.getStartDate()!=null,"billtime",billsVo.getStartDate());
        wrapper.ge(billsVo.getEndDate()!=null,"billtime",billsVo.getEndDate());
        wrapper.orderByDesc("billtime");
        IPage<Bills> billsIPage = billsMapper.selectPage(page, wrapper);
        return billsIPage;
    }

    @Override
    public void save(Bills bills) {
        billsMapper.update(bills,null);
    }


}
