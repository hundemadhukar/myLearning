package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import javax.sql.DataSource;
 
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.bean.Contact;
 
public class ContactDAOImpl implements ContactDAO {
 
    private JdbcTemplate jdbcTemplate;
 
    public ContactDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public void saveOrUpdate(Contact contact) {
		if (contact.getId() > 0) {
	        // update
	        String sql = "UPDATE contact SET name=?, email=?,"
	                    + "phone=? WHERE id=?";
	        jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
	        		contact.getPhone(), contact.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO contact (name, email, phone)"
	                    + " VALUES (?, ?, ?)";
	        jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
	                contact.getPhone());
	    }		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM contact WHERE id=?";
	    jdbcTemplate.update(sql, id);
		
	}

	@Override
	public Contact get(int id) {
	
		String sql = "SELECT * FROM contact WHERE id=" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Contact>() {
	 
	        @Override
	        public Contact extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Contact contact = new Contact();
	                contact.setId(rs.getInt("id"));
	                contact.setName(rs.getString("name"));
	                contact.setEmail(rs.getString("email"));
	                contact.setPhone(rs.getString("phone"));
	                return contact;
	            }
	 
	            return null;
	        }
	 
	    });
	}
	
	@Override
	public List<Contact> list() {
		String sql = "SELECT * FROM contact";
	    List<Contact> listOfContact = jdbcTemplate.query(sql, new RowMapper<Contact>() {
	 
	        @Override
	        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Contact contact = new Contact();
	 
	            contact.setId(rs.getInt("id"));
	            contact.setName(rs.getString("name"));
	            contact.setEmail(rs.getString("email"));
	            contact.setPhone(rs.getString("phone"));
	 
	            return contact;
	        }
	 
	    });
	 
	    return listOfContact;
	}
 
}