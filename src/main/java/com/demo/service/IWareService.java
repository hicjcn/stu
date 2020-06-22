package com.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.entity.StaffDO;
import com.demo.entity.WareDO;
import com.demo.entity.vo.StaffVO;
import com.demo.entity.vo.WareVO;

import java.util.List;

public interface IWareService {

    /**
     * 分页获取列表
     * @param pageNo
     * @return
     */
    IPage<WareDO> page(Integer pageNo);

    /**
     * 创建或者保存
     * @param wareVO
     * @return
     */
    boolean save(WareVO wareVO);

    /**
     * 删除
     * @param no
     */
    void delete(String no);

    /**
     * 获取全部商品
     * @return
     */
    List<WareDO> list();
}
