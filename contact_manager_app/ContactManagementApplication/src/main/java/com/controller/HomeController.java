package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Contact;
import com.service.ContactService;

@Controller
public class HomeController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/home")
	public ModelAndView listContact(ModelAndView model) throws IOException {
		List<Contact> listContact = contactService.list();
		model.addObject("listContact", listContact);
		model.setViewName("home");

		return model;
	}

	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("contactForm");
		return model;
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		contactService.saveOrUpdate(contact);
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		contactService.delete(id);
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactService.get(id);
		ModelAndView model = new ModelAndView("contactForm");
		model.addObject("contact", contact);

		return model;
	}
}
