package com.pp.controller;


import com.pp.common.DataGridView;
import com.pp.pojo.Billtype;
import com.pp.service.Billtypeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
@RequestMapping("/billtype")
public class BilltypeController {
    @Autowired
    private Billtypeservice billtypeservice;
    @RequestMapping("/loadAllBillType")
    @ResponseBody
    public DataGridView loadAllBillType(){
        System.out.println("进入了列表的方法");
        List<Billtype> billtypes = billtypeservice.FindAll();
        return new DataGridView(0L,billtypes);
    }
}
