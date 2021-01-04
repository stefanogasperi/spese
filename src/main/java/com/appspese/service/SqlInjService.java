package com.appspese.service;

import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import com.appspese.dao.EmailDAO;
import com.appspese.model.Email;


@Transactional
public class SqlInjService {
	
	@Resource (mappedName="java:jboss/datasources/GasSpringDS") //(mappedName="jdbc:/OracleDefaultDS") 
	DataSource datasource;
	
	@Inject
	private EmailDAO emailDao;
	
	public void q(String pwd) {
		try (Connection conn = datasource.getConnection()) {
			String sql = "SELECT * FROM email WHERE PASSWORD = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, pwd);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cq(String pwd) {
		List<Email> lem = emailDao.getByPwdCQ(pwd);
		for(Email email:lem) {
			System.out.println(email.getId()+" "+email.getAddress()+" "+email.getPassword());
		}
	}

}
