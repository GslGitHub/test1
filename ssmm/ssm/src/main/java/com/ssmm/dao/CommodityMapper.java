package com.ssmm.dao;


import com.ssmm.model.ymxCommodity;

import java.util.List;

public interface CommodityMapper {

    int insert(ymxCommodity c);

    int updateByPrimaryKey(ymxCommodity c);
    List<ymxCommodity> selectListBySku(String sku);
}