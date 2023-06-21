package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Contact;
import com.dao.ContactDAO;

@Service
public class ContactService {

	@Autowired
	private ContactDAO contactDAO;

	public void saveOrUpdate(Contact contact) {
		contactDAO.saveOrUpdate(contact);
	}

	public void delete(int id) {
		contactDAO.delete(id);
	}

	public Contact get(int id) {
		return contactDAO.get(id);
	}

	public List<Contact> list() {
		return contactDAO.list();
	}
}
