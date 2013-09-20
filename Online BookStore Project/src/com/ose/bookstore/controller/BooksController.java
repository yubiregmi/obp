/**
 * 
 */
package com.ose.bookstore.controller;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ose.bookstore.model.ejb.ShoppingCartDao;
import com.ose.bookstore.model.entity.Books;
import com.ose.bookstore.model.entity.ShoppingCart;

/**
 * @author nishant
 *
 */
@Named
@RequestScoped
public class BooksController implements Serializable{

	/**
	 * 
	 */
	@EJB
	ShoppingCartDao shoppingCartDao;
	
	@Inject
	ShoppingCart shoppingCart;
	@Inject
	Books currentBook;
	
	private static final long serialVersionUID = 1L;
	public BooksController()
	{}
	
	public void getId(Books books){
		
	}
	private static Map<Integer, Object> bookNumber;

	static {
		bookNumber = new LinkedHashMap<Integer, Object>();
		// bookNo.put(1,1);
		for (int i = 1; i <= 10; i++)
			bookNumber.put(i, i);

	}


	public Map<Integer, Object> getBookNo() {
		return bookNumber;
	}
	public String addToShoppingCart() {
//		Books book = getCurrentBook();
		System.out.println("Books Quantity: " + shoppingCart.getBookQuantity());
		System.out.println("Book Id: " + currentBook.getBookId());
		System.out.println("Shopping Book Id: " + shoppingCart.getBookId());
		// ShoppingCart sc = new ShoppingCart();
		 shoppingCart.setBookId(currentBook.getBookId());
//		 sc.setBookQuantity(shoppingCart.getBookQuantity());
		// System.out.println("From ShoppingCartController: "
		// + shoppingCart.getBookQuantity());
		// System.out.println("From sc: " + sc.getBookQuantity());
		 shoppingCartDao.add(shoppingCart);
//		return null;
		return "shoppingCart";
	}


	public String showBookDetails(Books books)
	{
		this.currentBook = books;
//		System.out.println("Book iD: " + books.getBookId());
//		System.out.println("book title:" + books.getTitle());
		return "bookProfile";
	}



	public Books getCurrentBook() {
		return currentBook;
	}

	public void setCurrentBook(Books currentBook) {
		this.currentBook = currentBook;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
