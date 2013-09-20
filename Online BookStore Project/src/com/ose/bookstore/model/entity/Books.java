package com.ose.bookstore.model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Books
 *
 */
@Entity

public class Books implements Serializable {

	
	private static final long serialVersionUID = 1L;


	
	@Id
	@GeneratedValue
	private int bookId;
	
//	@OneToMany(mappedBy = "books")
//	private Collection<ShoppingCart> shoppingcarts;
	private String title;
	private String author;
	private Double price;
	private String isbn;
	private String edition;
	private String pubDate;
	private String publisher;
	@Column(length=2000)
	private String description;
	private float discount;
	private String coverPage;

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getCoverPage() {
		return coverPage;
	}
	public void setCoverPage(String coverPage) {
		this.coverPage = coverPage;
	}
   
}
