package com.ssmm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ssmm.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssmm.model.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static org.apache.log4j.NDC.get;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	private static final String ENCODE = "UTF-8";

	@RequestMapping(value = "/test.do",method = RequestMethod.POST)
	@ResponseBody
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("userId");
		return id;
	}

	@RequestMapping(value = "/upload.do",method = RequestMethod.POST)
	@ResponseBody
	public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MultipartHttpServletRequest fileUploadRequest = (MultipartHttpServletRequest)request;
		MultipartFile file = fileUploadRequest.getFile("inputfile");
		InputStream inputS = file.getInputStream();

		userService.upload(inputS);

	}

	@RequestMapping(value = "/savecommodity.do",method = RequestMethod.POST)
	@ResponseBody
	public void savecommodity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String SKU = request.getParameter("SKU");
		String weight = request.getParameter("weight");
		String length = request.getParameter("length");
		String width = request.getParameter("width");
		String height = request.getParameter("height");
		ymxCommodity co = new ymxCommodity();
		co.setCommodityName(name);
		co.setCommoditySku(SKU);
		co.setCommodityWeight(Double.valueOf(weight));
		co.setLength(Double.valueOf(length));
		co.setWidth(Double.valueOf(width));
		co.setHeight(Double.valueOf(height));
		userService.saveCommodity(co);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void showOneUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap = userService.showChengBen();
		sentJson(response, resultMap);
	}

	/**
	 * FastJSON处理
	 * @param response
	 * @param <T> Collection
	 * @auher sunjc
	 */
	public static <T> void sentJson(HttpServletResponse response, T object) {
		try{
			String json = JSON.toJSONStringWithDateFormat(
					object,
					"yyyy-MM-dd HH:mm:ss",
					SerializerFeature.DisableCircularReferenceDetect
			);

			response.setContentType("text/json; charset=" + ENCODE);
			PrintWriter writer = response.getWriter();
			writer.print(json);
			writer.close();
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
