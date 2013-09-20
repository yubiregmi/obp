/**
 * 
 */
package com.ose.bookstore.controller;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ose.bookstore.model.ejb.BookListDao;
import com.ose.bookstore.model.entity.Books;

/**
 * @author nishant
 *
 */

@Named
@RequestScoped
public class HomeController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	BookListDao bookListDao;
	
	@Inject
	Books books;
	
	private String searchString;
	
	private List<Books> bookList;
	public String convertToCurrency(double price){
//		System.out.println(totalIncTax);
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
//		double price = 2.50000000000003;
		System.out.println(currencyFormatter.format(price));
		return currencyFormatter.format(price);
	}
	
	public List<Books> bookList(){
//		System.out.println(books.getCoverPage());
		System.out.println(searchString);
//		System.out.println(bookListDao.getBook(1));
		if (searchString != null){
			return bookListDao.search(searchString);
		}
		return bookListDao.getBookList();
	}
	public Books getBooks() {
		return books;
	}


	public void setBooks(Books books) {
		this.books = books;
	}
	public String getSearchString() {
		return searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	public List<Books> getBookList() {
		return bookList();
	}
	public void setBookList(List<Books> bookList) {
				this.bookList = bookList();
//		this.bookList = bookList;
	}

	
}
