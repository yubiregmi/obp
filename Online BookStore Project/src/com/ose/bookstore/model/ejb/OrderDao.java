/**
 * 
 */
package com.ose.bookstore.model.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ose.bookstore.model.entity.OrderDetail;

/**
 * @author nishant
 *
 */
@Stateless
@LocalBean
public class OrderDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(OrderDetail order){
		entityManager.merge(order);
	}
	
	
}
