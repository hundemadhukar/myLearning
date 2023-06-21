package com.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.Login;

@Repository
public class LoginDao {

	private JdbcTemplate jdbcTemplate;
	 
    public LoginDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public int signIn(Login login) {
		try {
List<Map<String, Object>> listQuery 
= 
jdbcTemplate.queryForList("select * from login where emailid=? and password = ?",login.getEmailid(),login.getPassword());
		return listQuery.size();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public int checkEmailid(Login login) {
		try {
List<Map<String, Object>> listQuery 
= 
jdbcTemplate.queryForList("select * from login where emailid=?",login.getEmailid());
		return listQuery.size();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	
	public String signUp(Login login) {
		try {
	int res = jdbcTemplate.update("insert into login values(?,?)", login.getEmailid(),login.getPassword());		
		if(res>0) {
			return "Account created successfully";
		}
		} catch (Exception e) {
			System.out.println(e);
			return "EmailId must be unique";
		}
		return null;
	}
	

}
