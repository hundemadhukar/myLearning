package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Contact;
import com.bean.Login;
import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	HomeController homeController;
	
	@RequestMapping(value = "/index")
	public ModelAndView getIndex(ModelAndView model) throws IOException {
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/signIn",method = RequestMethod.POST)
	public ModelAndView signIn(HttpServletRequest req,Login login,HttpSession hs) {
		String emailid = req.getParameter("emailid");
		String password = req.getParameter("password");
		login.setEmailid(emailid);
		login.setPassword(password);
		String result = loginService.signIn(login);
		ModelAndView mav = new ModelAndView();
		if(result.equalsIgnoreCase("success")) {
				//mav.setViewName("home");
			try {
				homeController.listContact(mav);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			mav.setViewName("failure");
		}
		return mav;
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView getSignUp(ModelAndView model) throws IOException {
		model.setViewName("signUp");
		return model;
	}
	
	@RequestMapping(value = "/signUp",method = RequestMethod.POST)
	public ModelAndView signUp(HttpServletRequest req, Login login) {
		String emailid = req.getParameter("emailid");
		String password = req.getParameter("password");
		login.setEmailid(emailid);
		login.setPassword(password);
		String result = loginService.signUp(login);
		ModelAndView mav = new ModelAndView();
			mav.addObject("msg", result);				// set value in model scope which can help to retrieve in view. 
		mav.setViewName("index");
		return mav;
	}
}
