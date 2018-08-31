package com.ssmm.dao;


import com.ssmm.model.ymxCommodityOtherpay;

import java.util.List;

public interface CommodityOtherpayMapper {

    int insert(ymxCommodityOtherpay c);

    int updateByPrimaryKey(ymxCommodityOtherpay c);
    List<ymxCommodityOtherpay> selectListByComId(String commId);
}