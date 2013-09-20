/**
 * 
 */
package com.ose.bookstore.controller;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ose.bookstore.model.ejb.OrderDao;
import com.ose.bookstore.model.entity.OrderDetail;
import com.ose.bookstore.model.entity.ShippingType;
import com.ose.bookstore.model.entity.UserDetails;
import com.ose.bookstore.model.helper.Cart;

/**
 * @author nishant
 * 
 */
@Named
@RequestScoped
public class OrderController implements Serializable {

	/**
	 * 
	 */
	@EJB
	OrderDao orderDao;
//	 @Inject
	 UserDetails currentUser;
	 ShippingType currentShipping;
	 Cart currentCart;
	 @Inject
	 OrderDetail order;
	 
	private static final long serialVersionUID = 1L;
//	String shippingType;
////	static ShoppingCartController uc;
//	public String getShippingType() {
//		return shippingType;
//	}
//
//	public void setShippingType(String shippingType) {
//		this.shippingType = shippingType;
//	}

	String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

//	public String action() {
//		System.out.println("from jsf: " + shippingType);
//		System.out.println("firstName: " + userDetails.getFname());
//		System.out.println(userDetails);
////		System.out.println(uc.cartList());
//		return "test";
//		// return "home";
//		// System.out.println("propertyName2: " + propertyName2);
//	}
	public String action(UserDetails userDetails, int shippingType, List<Cart> cartList) {
		this.currentUser = userDetails;
//		this.currentShipping = shippingType;
//		this.currentCart =
//		System.out.println("from jsf: " + shippingType);
		System.out.println("firstName: " + userDetails.getFname());
		System.out.println("Current User: " + currentUser.getFname());
		System.out.println("Shipping type: " + shippingType);
		System.out.println(cartList);
		for (int i = 0; i < cartList.size(); i++) {
			order.setShippingId(i);
			 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		        Date date = new Date();
			Date d1 = new Date();
//			SimpleDateFormat df = new SimpleDateFormat('MM/dd/YYYY HH:mm AM');
			String formattedDate = dateFormat.format(d1);
			order.setDate(formattedDate);
			order.setBookId(cartList.get(i).getBookId());
			order.setUserId(userDetails.getUserId());
			order.setStatus(i);
			orderDao.create(order);
//			order.setBookId(bookId);
//			System.out.println(cartList.get(i).getBookId());
//			System.out.println(cartList.get(i).getAuthor());
			
		}
//		System.out.println(userDetails);
//		System.out.println(uc.cartList());
		return "test";
		// return "home";
		// System.out.println("propertyName2: " + propertyName2);
	}
//	public static void main(String[] args) {
//		FacesContext context = FacesContext.getCurrentInstance();
//		UserDetails userDetails = (UserDetails) context.getApplication()
//				.evaluateExpressionGet(context, "#{userDetails}",
//						UserDetails.class);
//		System.out.println(userDetails);
//	}

	public UserDetails getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(UserDetails currentUser) {
		this.currentUser = currentUser;
	}

	public ShippingType getCurrentShipping() {
		return currentShipping;
	}

	public void setCurrentShipping(ShippingType currentShipping) {
		this.currentShipping = currentShipping;
	}

	public Cart getCurrentCart() {
		return currentCart;
	}

	public void setCurrentCart(Cart currentCart) {
		this.currentCart = currentCart;
	}

	public OrderDetail getOrder() {
		return order;
	}

	public void setOrder(OrderDetail order) {
		this.order = order;
	}


}
