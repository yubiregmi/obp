/**
 * 
 */
package com.ose.bookstore.model.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ose.bookstore.model.entity.Login;

/**
 * @author nishant
 * 
 */

@Stateless
@LocalBean
public class LoginDao {

	@PersistenceContext
	private EntityManager entityManager;

	// @Override
	public void writeToDb(Login login) {
		// entityManager.persist(login);
		System.out.println("from ejb");
		System.out.println(login.getPassword());
		System.out.println(login.getSecPassword());
		System.out.println(login.getUserEmail());

		System.out.println(login.getLoginId());
		// Login login1 = new Login();
		// login1.setLoginId(3);
		// login1.setPassword("nopass");
		// login1.setSecPassword("nopass1");
		// login1.setUserEmail("yser@yser.com");
		entityManager.persist(login);
	}

	//
	// public List<String> findAll() {
	//
	// Query query = entityManager.createQuery("Select l.password from Login l",
	// Login.class);
	// // javax.persistence.criteria.CriteriaQuery cq =
	// entityManager.getCriteriaBuilder().createQuery();
	// // cq.select(cq.from(Login.class));
	// List<String> results = query.getResultList();
	// // List<Login> results = query.getResultList();
	// return results;
	// }
	// //

	public Boolean checkUser(Login login) {
		Boolean flag = false;
		String username = login.getUserEmail();
		String password = login.getPassword();
		javax.persistence.criteria.CriteriaQuery cq = entityManager
				.getCriteriaBuilder().createQuery();
		cq.select(cq.from(Login.class));
		// List<String> results = query.getResultList();
		List<Login> results = entityManager.createQuery(cq).getResultList();
		Login login1 = new Login();
		for (int i = 0; i < results.size(); i++) {
			login1 = results.get(0);
//			System.out.println(login1.getUserEmail());
		}
		if (login1.getUserEmail().equals(username) && (login1.getPassword().equals(password))){
			System.out.println("Success");
			flag = true;
			System.out.println(flag);
		}
		System.out.println(username);
		System.out.println(password);
		

		return flag;
	}

}
