package com.pp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pp.common.DataGridView;
import com.pp.common.ResultObj;
import com.pp.pojo.Bills;
import com.pp.pojo.BillsVo;
import com.pp.pojo.Billtype;
import com.pp.service.Billsservice;
import com.pp.service.Billtypeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pp
 * @since 2020-05-30
 */
@Controller
@RequestMapping("/bills")
public class BillsController {
    @Autowired
    private  Billsservice billsservice;
    @Autowired
    private Billtypeservice billtypeservice;
    @RequestMapping("/toBillsList")
    public String toBillsList(){
        return "list";
    }
    @ResponseBody
    @RequestMapping("/loadAllBills")
    public DataGridView loadAllBills(BillsVo billsVo){
        IPage<Bills> bills = billsservice.FindAllBills(billsVo);
        System.out.println("得到的数据”："+bills.getRecords());
        System.out.println("总数据条数"+bills.getTotal());
        System.out.println("当前页数"+bills.getPages());
        List<Bills> records = bills.getRecords();
        for (Bills bill:records
             ) {

            Billtype byId = billtypeservice.getById(bill.getTypeid());
            bill.setTypename(byId.getName());
        }
        List<Billtype> billtypes = billtypeservice.FindAll();
        return new DataGridView(bills.getTotal(),bills.getRecords());
    }
    @RequestMapping("/addBills")
    @ResponseBody
    public ResultObj addBills(Bills bills){
        try {
            billsservice.save(bills);
            return new ResultObj(200,"录入成功");
        } catch (Exception e) {
            return new ResultObj(-1,"录入失败");
        }
    }

}
