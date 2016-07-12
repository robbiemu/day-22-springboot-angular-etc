package com.cooksys.springboot.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cooksys.springboot.dao.UserDao;
import com.cooksys.springboot.model.RoleModel;
import com.cooksys.springboot.model.UserModel;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	EntityManager em;
	
	public List<UserModel> readUsers() {
		return em.createQuery("from UserModel", UserModel.class).getResultList();
	}
	
	public UserModel readUser(Integer pk){
		return em.find(UserModel.class, pk);
	}
	
	public UserModel createUser(UserModel usermodel) {
		em.persist(usermodel);
		return usermodel;
	}

	public UserModel updateUser(Integer pk, UserModel usermodel) {
		UserModel u = em.find(UserModel.class, pk);
		String city = usermodel.getCity() ;
		if(city != null) {
			u.setCity(city);			
		}
		String name = usermodel.getName();
		if(name != null) {
			u.setName(name);			
		}
		String state = usermodel.getState() ;
		if(state != null) {
			u.setState(state);			
		}

		em.persist(u); 
		
//		usermodel.setId(pk);
//		em.merge(usermodel);
//		return usermodel;

		return u;
	}

	public UserModel deleteUser(Integer pk) {
		UserModel u = em.createQuery("from UserModel where id = :id", UserModel.class)
				.setParameter("id", pk)
				.getSingleResult();
		em.remove(u);

		return u;
	}

	public RoleModel readRole(Integer pk) {
		return em.find(UserModel.class, pk).getRolemodel();
	}

	public RoleModel setRole(Integer pk, Integer rpk) {
		RoleModel r = em.find(RoleModel. class, rpk);
		UserModel u = em.find(UserModel.class, pk);
		u.setRolemodel(r);

		em.persist(u);

		return r;
	}

	public UserModel deleteRole(Integer pk) {
		UserModel u = em.find(UserModel.class, pk);
		u.setRolemodel(null);

		em.persist(u);

		return u;
	}

}
