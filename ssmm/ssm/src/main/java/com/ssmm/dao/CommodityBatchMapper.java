package com.ssmm.dao;


import com.ssmm.model.ymxCommodityBatch;

import java.util.List;

public interface CommodityBatchMapper {

    int insert(ymxCommodityBatch c);

    int updateByPrimaryKey(ymxCommodityBatch c);
    List<ymxCommodityBatch> getBatchs();
}