/**
 * 
 */
package com.ose.bookstore.controller;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.ose.bookstore.model.ejb.BookListDao;
import com.ose.bookstore.model.ejb.ShoppingCartDao;
import com.ose.bookstore.model.entity.Books;
import com.ose.bookstore.model.entity.ShoppingCart;
import com.ose.bookstore.model.helper.Cart;

/**
 * @author nishant
 * 
 */
@Named
@RequestScoped
public class ShoppingCartController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ShoppingCartDao shoppingCartDao;

	@EJB
	BookListDao bookListDao;

	@Inject
	ShoppingCart shoppingCart;
	@NotNull(message = "Select the shipping type")
	private int shippingType;
	// @Inject
	Cart scart;
	// Books book;
	// UserDetails userDetails

	// Double[] tpwithoutTaxShip;
	double tp;
	List<Cart> cartList;

	//
	// public String showQuant(){
	// System.out.println("Books Quantity: " + shoppingCart.getBookQuantity());
	// return "home";
	// }
	// public void addToShoppingCart() {
	// System.out.println("Books Quantity: " + shoppingCart.getBookQuantity());
	// System.out.println("Shopping Book Id: " + shoppingCart.getBookId());
	// // ShoppingCart sc = new ShoppingCart();
	// // sc.setBookId(book.getBookId());
	// // sc.setBookQuantity(shoppingCart.getBookQuantity());
	// // System.out.println("From ShoppingCartController: "
	// // + shoppingCart.getBookQuantity());
	// // System.out.println("From sc: " + sc.getBookQuantity());
	// // shoppingCartDao.add(shoppingCart);
	//
	// }

	public List<Cart> cartList() {
		System.out.println("button clicked:");
		List<ShoppingCart> cart = shoppingCartDao.getCart(0);
		System.out.println("List: " + cart);
		// List<Books> books = bookListDao.getBookList();

		Books book = new Books();
		List<Cart> cartList = new ArrayList<Cart>();
		tp = 0.0;
		for (int i = 0; i < cart.size(); i++) {
			book = bookListDao.getBook(cart.get(i).getBookId());
			System.out.println(book.getBookId());
			tp += ((book.getPrice() - (book.getPrice() * book.getDiscount())) * cart
					.get(i).getBookQuantity());
			Cart cart1 = new Cart(book.getBookId(),
					book.getAuthor(),
					book.getTitle(),
					book.getEdition(),
					book.getPrice(),
					book.getDiscount(),
					cart.get(i).getBookQuantity(),
					((book.getPrice() - (book.getPrice() * book.getDiscount())) * cart
							.get(i).getBookQuantity()), book.getCoverPage());
			// tpwithoutTaxShip[i] = tp;
			System.out.println(book);
			cartList.add(cart1);
			System.out.println("From instance: " + cart1.getBookId());
			// totalwoTaxShipp = tp;
		}

		// for (int j = 0; j < books.size(); j++) {
		// // System.out.println("BOok size: " + cart.size());
		// if (cart.get(i).getBookId() == books.get(j).getBookId()) {
		// System.out.println("bookid from shopping cart table:" +
		// cart.get(i).getBookId());
		// System.out.println("bookid from book table: " +
		// books.get(j).getBookId());
		// scart.setAuthor(books.get(j).getAuthor());
		// scart.setTitle(books.get(j).getTitle());
		// scart.setEdition(books.get(j).getEdition());
		// scart.setPrice(books.get(j).getPrice());
		// scart.setDiscount(books.get(j).getDiscount());
		// scart.setQuantity(cart.get(i).getBookQuantity());
		// scart.setTotalPrice((books.get(j).getPrice()-(books.get(j).getPrice())*(books.get(j).getDiscount()))*cart.get(i).getBookQuantity());
		// cartList.add(scart);
		// System.out.println("current cart: " + scart);
		// // System.out.println("BOok size: " + books.size());
		// // scart = null;
		// }
		// System.out.println("Cart List: " + scart);

		System.out.println("Cart List: " + cartList);

		return cartList;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	// public void addToShoppingCart() {
	// // Books book = getCurrentBook();
	// System.out.println("Books Quantity: " + shoppingCart.getBookQuantity());
	// // System.out.println("Book Id: " + book.getBookId());
	// System.out.println("Shopping Book Id: " + shoppingCart.getBookId());
	// // ShoppingCart sc = new ShoppingCart();
	// // sc.setBookId(book.getBookId());
	// // sc.setBookQuantity(shoppingCart.getBookQuantity());
	// // System.out.println("From ShoppingCartController: "
	// // + shoppingCart.getBookQuantity());
	// // System.out.println("From sc: " + sc.getBookQuantity());
	// // shoppingCartDao.add(shoppingCart);
	//
	// }

	// private static Map<Integer, Object> bookNumber;
	//
	// static {
	// bookNumber = new LinkedHashMap<Integer, Object>();
	// // bookNo.put(1,1);
	// for (int i = 1; i <= 10; i++)
	// bookNumber.put(i, i);
	//
	// }
	//
	// public Map<Integer, Object> getBookNo() {
	// return bookNumber;
	// }

	public List<Cart> getCartList() {
		return cartList();
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList();
	}

	//
	// public Double getTpwithoutTaxShip() {
	// return tpwithoutTaxShip;
	// }
	//
	// public void setTpwithoutTaxShip(Double tpwithoutTaxShip) {
	// this.tpwithoutTaxShip = tpwithoutTaxShip;
	// }

	public String getTp() {
		List<ShoppingCart> cart = shoppingCartDao.getCart(0);
		Books book = new Books();
		// List<Cart> cartList = new ArrayList<Cart>();
		tp = 0.0;
		for (int i = 0; i < cart.size(); i++) {
			book = bookListDao.getBook(cart.get(i).getBookId());

			tp += ((book.getPrice() - (book.getPrice() * book.getDiscount())) * cart
					.get(i).getBookQuantity());
		}
		return convertToCurrency(tp);
	}

	public void setTp(double tp) {
		this.tp = tp;
	}

	public int getShippingType() {
		return shippingType;
	}

	public void setShippingType(int shippingType) {
		this.shippingType = shippingType;
//		newTotal = (float) (tp+tax);
		
		System.out.println(shippingType);
//		this.shippingType = shippingType;
	}
	

	public String convertToCurrency(double price){
//		System.out.println(totalIncTax);
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
//		double price = 2.50000000000003;
		System.out.println(currencyFormatter.format(price));
		return currencyFormatter.format(price);
	}
	
	public String getTotalIncTax() {
//		System.out.println(totalIncTax);
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
//		double price = 2.50000000000003;
//		System.out.println(currencyFormatter.format(price));
		
		double totalExTax = tp + shippingType;
		System.out.println(totalExTax);
		totalIncTax = totalExTax + totalExTax*.15;
//		convertToCurrency(totalIncTax);
		System.out.println(currencyFormatter.format(totalIncTax));
//		this.newTotal = newTotal;
		return convertToCurrency(totalIncTax);
		
	}
	public void setTotalIncTax(double totalIncTax) {
		
		this.totalIncTax = totalIncTax;
		System.out.println(totalIncTax);
	}

	private double totalIncTax;
//	private float shippingCost;
}
