/**
 * 
 */
package com.ose.bookstore.controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ose.bookstore.model.ejb.LoginDao;
import com.ose.bookstore.model.entity.Login;

/**
 * @author nishant
 *
 */
@Named
@RequestScoped
public class LoginAuthentication {
	@EJB
	LoginDao loginDao;
	
	@Inject 
	Login login;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public String authenticateLogin(){
		Boolean flag;
		flag = loginDao.checkUser(login);
		return "home.xhtml";
	}
}
