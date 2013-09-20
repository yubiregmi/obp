/**
 * 
 */
package com.ose.bookstore.controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ose.bookstore.model.ejb.UserAccountDao;
import com.ose.bookstore.model.entity.UserDetails;

/**
 * @author nishant
 *
 */
@Named
@RequestScoped
public class UserAccountController {

	@EJB
	UserAccountDao userAccountDao;
	
	@Inject
	UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public String editDetails(){
//		List<UserDetails> user = userAccountDao.display();
//		this.userDetails = userAccountDao.getUser(1);
		System.out.println("UserId:" + userDetails.getUserId());
		System.out.println("Fname: " + userDetails.getFname());
		System.out.println("Mname: " + userDetails.getMname());
		userAccountDao.editUser(userDetails);
		return "null";
	}
	
	public String toOrderPage(){
		this.userDetails = userAccountDao.getUser(1);
		System.out.println("First Name : " + this.userDetails.getFname());
		return "orderBooks";
	}
	
	public String showDetails(){
		System.out.println("Hello : sadfsdaF");
		this.userDetails = userAccountDao.getUser(1);
		System.out.println("First Name : " + this.userDetails.getFname());
		return "editDetails";
	}
	
}
