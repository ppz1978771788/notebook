package com.pp;

import com.pp.mapper.BillsMapper;
import com.pp.pojo.Bills;
import com.pp.pojo.BillsVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NotebookApplicationTests {
@Autowired
     private BillsMapper billsMapper;
@Autowired
    private  BillsVo billsVo;
    @Test
    void contextLoads() {
        BillsVo billsVo = new BillsVo();
        billsVo.setLimit(2);
       billsVo.setPage(1);

        System.out.println(billsMapper.FindAllBills(billsVo));
        //System.out.println(billsMapper.FindAllBill());
    }

}
