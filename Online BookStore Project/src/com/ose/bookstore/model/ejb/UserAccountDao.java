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

import com.ose.bookstore.model.entity.Books;
import com.ose.bookstore.model.entity.UserDetails;

/**
 * @author nishant
 *
 */
@Stateless
@LocalBean
public class UserAccountDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<UserDetails> display(){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder(); //invokes the getCriteriaBuilder() method on the entity manager
		CriteriaQuery<UserDetails> query = cb.createQuery(UserDetails.class); //obtains the instance of Contacts class implementing CriteriaQuery interface
		Root<UserDetails> c = query.from(UserDetails.class);//Jpa entity to be querying from (equivalent to 'from' in SQL)
		query.select(c);
		query.orderBy(cb.asc(c.get("fname")));//Orders by Firstname

		return entityManager.createQuery(query).getResultList();
	}
	
	public UserDetails getUser(int userId){
		UserDetails ud = entityManager.find(UserDetails.class, userId);
		return ud;
	}
	
	public void editUser(UserDetails ud){
		System.out.println(ud.getFname());
		System.out.println(ud.getUserId());
		System.out.println(ud.getMname());
		entityManager.merge(ud);
		
	}
}
