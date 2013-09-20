/**
 * 
 */
package com.ose.bookstore.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ose.bookstore.model.ejb.LoginDao;
import com.ose.bookstore.model.entity.Login;
import com.ose.bookstore.model.entity.UserDetails;

/**
 * @author nishant
 * 
 */
// @ManagedBean
@Named
@RequestScoped
public class HeaderController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	LoginDao loginDao;

	@Inject
	// @ManagedProperty(value="#{login}")
	Login login;
	//
	// @Inject
	// Books books;

	UserDetails currentUser;

//	 List<Cart> cartList;

	public HeaderController() {
		// login = new Login();
		// login.setLoginId(2);
		// login.setSecPassword("secPassword");
		// login.setPassword("asdf");
		// login.setUserEmail("sadf");
	}

	// public String generateCart(){
	// List<ShoppingCart> cartList = shoppingCartDao.getCart();
	// // List<Books> books = bookListDao.getBookList();
	// // List<ShoppingCart> sc = shoppingCartDao.getCart();
	// // for (int i = 0; i < sc.size(); i++) {
	// //
	// //
	// // }
	// return "shoppingCart";
	// }
	public String generateCart() {
		
		
		return "shoppingCart";
	}

	public String enterLogin() {

		// LoginDao loginDao = new LoginDao();
		System.out.println(login.getPassword());
		System.out.println(login.getSecPassword());
		System.out.println(login.getUserEmail());

		loginDao.writeToDb(login);
		// System.out.println(loginDao.findAll());
		// System.out.println(loginDao.findAll());
		// Iterator it = (Iterator) loginDao.findAll().iterator();
		// while(it.hasNext()){
		// System.out.println(it.next());
		// }
		return "confirmation.xhtml";
	}

	public Login getLogin() {
		// if (login == null) {
		// login = new Login();
		// }
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public UserDetails getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(UserDetails currentUser) {
		this.currentUser = currentUser;
	}

	// public Books getBooks() {
	// return books;
	// }
	//
	// public void setBooks(Books books) {
	// this.books = books;
	// }

	

//	public List<Cart> getCartList() {
//		return cartList;
//	}
//
//	public void setCartList(List<Cart> cartList) {
//		this.cartList = cartList;
//	}

}
