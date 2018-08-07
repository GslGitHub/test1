package com.ssmm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssmm.model.User;
import com.ssmm.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.apache.log4j.NDC.get;

@Controller
public class UserController {
	@Autowired
	private UserService userService;


	@RequestMapping(value = "/test.do",method = RequestMethod.POST)
	@ResponseBody
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("userId");
		return id;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	User showOneUser(@PathVariable("id") int id) {

		return userService.getUserById(id);
	}
}
