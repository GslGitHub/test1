package com.ssmm.service;

import com.ssmm.dao.CommodityBatchMapper;
import com.ssmm.dao.CommodityMapper;
import com.ssmm.dao.CommodityOtherpayMapper;
import com.ssmm.model.*;
import com.ssmm.util.UUIDHexGenerator;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ssmm.model.User;
import com.ssmm.service.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service("userService")
public class UserService {

	@Autowired
	private CommodityMapper commodityMapper;
	@Autowired
	private CommodityBatchMapper commodityBatchMapper;
	@Autowired
	private CommodityOtherpayMapper commodityOtherpayMapper;


	public String saveCommodity(ymxCommodity co) {

		List<ymxCommodity> comList = commodityMapper.selectListBySku(co.getCommoditySku());
		if(comList == null || comList.size() < 1){
            co.setId(UUIDHexGenerator.get());
			commodityMapper.insert(co);
		}else{
		    co.setId(comList.get(0).getId());
            commodityMapper.updateByPrimaryKey(co);
		}
		return co.getId();
	}
	public void saveCommodityBatch(ymxCommodityBatch cob) {
		cob.setId(UUIDHexGenerator.get());
		commodityBatchMapper.insert(cob);
	}
	public void saveCommodityOtherpay(ymxCommodityOtherpay coo) {

		List<ymxCommodityOtherpay> comList = commodityOtherpayMapper.selectListByComId(coo.getCommodityId());
		if(comList == null || comList.size() < 1){
            coo.setId(UUIDHexGenerator.get());
			commodityOtherpayMapper.insert(coo);
		}else{
		    coo.setId(comList.get(0).getId());
            commodityOtherpayMapper.updateByPrimaryKey(coo);
		}
	}

    public void upload(InputStream inputS) {
		try {
			Workbook wb = WorkbookFactory.create(inputS);
			if(wb.getNumberOfSheets()<1){
				return;
			}
			Sheet hssfSheet = wb.getSheetAt(0);
			if (hssfSheet == null) {
					return;
			}
				//隐藏行（元素id）
				Row hiddenRow = hssfSheet.getRow(0);
				//首行
				Row headRow = hssfSheet.getRow(1);
				//列数
				Short colNum = headRow.getLastCellNum();

			List<ymxCommodity> commoditieList = new ArrayList<ymxCommodity>();
			List<ymxCommodityBatch> commoditieBatchList = new ArrayList<ymxCommodityBatch>();
			List<ymxCommodityOtherpay> commoditieOtherpayList = new ArrayList<ymxCommodityOtherpay>();

				// 循环行Row,循环
				for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
					Row hssfRow = hssfSheet.getRow(rowNum);
					if (hssfRow != null) {
						ymxCommodity co = new ymxCommodity();
						ymxCommodityBatch cb = new ymxCommodityBatch();
						ymxCommodityOtherpay coo = new ymxCommodityOtherpay();
						for(int i=0;i<colNum;i++){
							String name = getValue(hssfRow.getCell(i));
							String sku = getValue(hssfRow.getCell(i));
							String weight = getValue(hssfRow.getCell(i));
							String length= getValue(hssfRow.getCell(i));
							String width = getValue(hssfRow.getCell(i));
							String height = getValue(hssfRow.getCell(i));
							co.setCommodityName(name);
							co.setCommoditySku(sku);
							co.setCommodityWeight(Double.valueOf(weight));
							co.setLength(Double.valueOf(length));
							co.setWidth(Double.valueOf(width));
							co.setHeight(Double.valueOf(height));
							String commodityId = saveCommodity(co);

							String batchPrice = getValue(hssfRow.getCell(i));
							String num = getValue(hssfRow.getCell(i));
							String yunfei = getValue(hssfRow.getCell(i));
							cb.setBatchPrice(Double.valueOf(batchPrice));
							cb.setNum(Integer.valueOf(num));
							cb.setYunfei(Double.valueOf(yunfei));
							cb.setCommodityId(commodityId);
                            saveCommodityBatch(cb);

							String selaPrice = getValue(hssfRow.getCell(i));
							String commission = getValue(hssfRow.getCell(i));
							String ad = getValue(hssfRow.getCell(i));
							String service = getValue(hssfRow.getCell(i));
							String returnFei = getValue(hssfRow.getCell(i));
							coo.setSelaPrice(Double.valueOf(selaPrice));
							coo.setAd(Double.valueOf(ad));
							coo.setService(Double.valueOf(service));
							coo.setCommission(Double.valueOf(commission));
							coo.setReturnPrice(Double.valueOf(returnFei));
							coo.setCommodityId(commodityId);
                            saveCommodityOtherpay(coo);
						}


					}
				}
		}catch(Exception n){
			n.printStackTrace();
			return ;
		}finally{
			try {
				inputS.close();
				return ;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }

	@SuppressWarnings("static-access")
	private String getValue(Cell hssfCell) {
		if(hssfCell == null){
			return "";
		}else{
			if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
				// 返回布尔类型的值
				return String.valueOf(hssfCell.getBooleanCellValue());
			} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
				// 返回数值类型的值
				return String.valueOf(hssfCell.getNumericCellValue());
			} else {
				// 返回字符串类型的值
				return String.valueOf(hssfCell.getStringCellValue());
			}
		}
	}


	//计算成本
	public  ymxCommodity mathChengBen(ymxCommodity co,ymxCommodityBatch cb,ymxCommodityOtherpay coo){
		double  profits = coo.getSelaPrice() - coo.getService()- coo.getCommission() - coo.getReturnPrice()- coo.getAd()
				- cb.getSumPrice() - cb.getSumYunfei();
		co.setProfits(profits);
		return co;
	}


    public Map<String,Object> showChengBen() {
        Map<String,Object> chengBenMap = new HashMap<String,Object>();
        List<ymxCommodityBatch> batchList = commodityBatchMapper.getBatchs();
    }
}
