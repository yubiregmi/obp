/**
 * 
 */
package com.ose.bookstore.model.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ose.bookstore.model.entity.ShoppingCart;

/**
 * @author nishant
 * 
 */
@Stateless
@LocalBean
public class ShoppingCartDao {

	@PersistenceContext
	private EntityManager entityManager;

	
	public void add(ShoppingCart shoppingCart) {
//		ShoppingCart sc = new ShoppingCart();
//		int pid = shoppingCart.ge
//		sc = entityManager.find(ShoppingCart.class, shoppingCart.getBookId());
////		
//		System.out.println("Selected BOok: " + shoppingCart.getBookId());
//		System.out.println("Shopping Cart Selected: ");
//		System.out.print(sc);
//		if (sc.getBookId() == shoppingCart.getBookId()){
//			shoppingCart.setBookQuantity(shoppingCart.getBookQuantity()+ sc.getBookQuantity());
//		}
//		System.out.println(shoppingCart.getBookQuantity());
		List<ShoppingCart> sCart = getCart(0);
		for (int i = 0; i < sCart.size(); i++) {
			if (sCart.get(i).getBookId() == shoppingCart.getBookId() && sCart.get(i).getUserId() == shoppingCart.getUserId()){
				shoppingCart.setBookQuantity(shoppingCart.getBookQuantity()+ sCart.get(i).getBookQuantity());
				shoppingCart.setScId(sCart.get(i).getScId());
//				shoppingCart.setBookId(sCart.get(i).getBookId());
			}
		}
//		shoppingCart.set
		
//		if (getCart().get(index))
		entityManager.merge(shoppingCart);
	}

	public void delete(ShoppingCart shoppingCart){
		
		
	}
	public List<ShoppingCart> getCart(int userID) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder(); //invokes the getCriteriaBuilder() method on the entity manager
		CriteriaQuery<ShoppingCart> query = cb.createQuery(ShoppingCart.class); //obtains the instance of Contacts class implementing CriteriaQuery interface
		Root<ShoppingCart> c = query.from(ShoppingCart.class);//Jpa entity to be querying from (equivalent to 'from' in SQL)
		query.select(c);
//		.where(cb.equal(c.get("USERID"),userID));
//		query.orderBy(cb.asc(c.get("userId")));//Orders by 
		
		return entityManager.createQuery(query).getResultList();
	}
	
//	public List<Cart> CartList(){
//		
//		return void;
//	}
//	public List<>
}
