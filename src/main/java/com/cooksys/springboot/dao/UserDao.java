package com.cooksys.springboot.dao;

import java.util.List;

import com.cooksys.springboot.model.RoleModel;
import com.cooksys.springboot.model.UserModel;

public interface UserDao {
	public UserModel createUser(UserModel usermodel);
	public UserModel updateUser(Integer pk, UserModel usermodel) ;
	public UserModel deleteUser(Integer pk);
	public RoleModel readRole(Integer pk);
	public RoleModel setRole(Integer pk, Integer rpk);
	public UserModel deleteRole(Integer pk);
	public UserModel readUser(Integer pk);
	public List<UserModel> readUsers() ;
}
