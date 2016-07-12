package com.cooksys.springboot;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cooksys.springboot.model.RoleModel;
import com.cooksys.springboot.model.UserModel;
import com.cooksys.springboot.dao.UserDao;

@Repository
public class DemoRepository {

	@Autowired
	EntityManager em;
	
	@Autowired
	UserDao userdao;
	
	// this would normally be a call to a dao impl.. or it would actually *be* a dao instead of a "repository"
	public String readHello() {
		return "hello";
	}

	public UserModel readUser(Integer pk){
		return userdao.readUser(pk);
	}
	
	public List<UserModel> readUsers() {
		return userdao.readUsers();
	}

	public UserModel createUser(UserModel usermodel) {
		return userdao.createUser(usermodel);
	}

	public UserModel updateUser(Integer pk, UserModel usermodel) {
		return userdao.updateUser(pk, usermodel);
	}

	public UserModel deleteUser(Integer pk) {
		return userdao.deleteUser(pk);
	}

	public RoleModel readRole(Integer pk) {
		return userdao.readRole(pk);
	}

	public RoleModel setRole(Integer pk, Integer rpk) {
		return userdao.setRole(pk, rpk);
	}

	public UserModel deleteRole(Integer pk) {
		return userdao.deleteRole(pk);
	}

}
