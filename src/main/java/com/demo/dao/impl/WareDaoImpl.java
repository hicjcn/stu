package com.demo.dao.impl;

import com.demo.entity.WareDO;
import com.demo.mapper.WareDOMapper;
import com.demo.dao.IWareDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品登记表 服务实现类
 * </p>
 *

 */
@Service
public class WareDaoImpl extends ServiceImpl<WareDOMapper, WareDO> implements IWareDao {

    /**
     * 获取目前商品最大编号
     *
     * @param wareType
     * @return
     */
    @Override
    public int getMaxIdByWareType(int wareType) {
        String key = wareType + "%";
        return this.baseMapper.getMaxIdByWareType(key);
    }
}
