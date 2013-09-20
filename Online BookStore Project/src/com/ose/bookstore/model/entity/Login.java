package com.ose.bookstore.model.entity;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Login
 *
 */
@ManagedBean
//@Named
//@RequestScoped
@Entity
public class Login implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int loginId;
	private String userEmail;
	private String password;
	private String secPassword;
	
	public Login(){
//		Login login = new Login();	
	}

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecPassword() {
		return secPassword;
	}
	public void setSecPassword(String secPassword) {
		this.secPassword = secPassword;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
   
}
