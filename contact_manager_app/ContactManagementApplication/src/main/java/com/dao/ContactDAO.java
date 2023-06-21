package com.dao;

import java.util.List;
import com.bean.Contact;

public interface ContactDAO {

	public void saveOrUpdate(Contact contact);
    
    public void delete(int id);
     
    public Contact get(int id);
     
    public List<Contact> list();
}
