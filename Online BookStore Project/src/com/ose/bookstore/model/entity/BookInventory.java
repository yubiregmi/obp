package com.ose.bookstore.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: BookInventory
 * 
 */
@Entity
public class BookInventory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int biId;
	private int bookId;
	private int booksInStock;

	public int getBiId() {
		return biId;
	}

	public void setBiId(int biId) {
		this.biId = biId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBooksInStock() {
		return booksInStock;
	}

	public void setBooksInStock(int booksInStock) {
		this.booksInStock = booksInStock;
	}

}
