package com.pp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pp.pojo.Bills;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pp.pojo.BillsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pp
 * @since 2020-05-30
 */
public interface Billsservice  {
    IPage<Bills> FindAllBills(BillsVo billsVo);

    void save(Bills bills);
}
