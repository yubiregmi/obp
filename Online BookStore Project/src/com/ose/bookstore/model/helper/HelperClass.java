/**
 * 
 */
package com.ose.bookstore.model.helper;

import java.io.Serializable;

/**
 * @author nishant
 *
 */
public class HelperClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String author;
	private String title;
	private String edition;
	private int price;
	private float discount;
	private int quantity;
	private double totalPrice;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
