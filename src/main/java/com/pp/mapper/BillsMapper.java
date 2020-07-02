package com.pp.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pp.pojo.Bills;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pp.pojo.BillsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pp
 * @since 2020-05-30
 */

@Repository
public interface BillsMapper extends BaseMapper<Bills> {
    List<Bills> FindAllBills(BillsVo billsVo);
    @Select("select b.*,bs.name typename from bills as b join billtype bs on b.typeid=bs.id")
    List<Bills> FindAllBills();

}
