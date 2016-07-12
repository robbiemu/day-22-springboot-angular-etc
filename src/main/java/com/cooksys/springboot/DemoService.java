package com.cooksys.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.springboot.model.RoleModel;
import com.cooksys.springboot.model.UserModel;

@Service
public class DemoService {

	@Autowired
	DemoRepository repository;
	
	public String hello() {
		// process logic around getting repository result
		String result = repository.readHello();
		// process logic around result data-set, such as:
		result = wrap_in_html(result);
		return result;		
	}

	private String wrap_in_html(String result) {
		// this could be replaced with @ResponseBody
		return "<!DOCTYPE html><html><head><title>Springboot demo - dynamic html response</title></head><body>"+result+"</body></html>";
	}

	public String echo(String snippet) {
		return wrap_in_html(snippet);
	}

	public List<UserModel> readUsers() {
		return repository.readUsers();
	}

	public UserModel readUser(Integer pk) {
		return repository.readUser(pk);
	}

	public UserModel createUser(UserModel usermodel) {
		return repository.createUser(usermodel);
	}

	public UserModel updateUser(Integer pk, UserModel usermodel) {
		return repository.updateUser(pk, usermodel);
	}

	public UserModel deleteUser(Integer pk) {
		return repository.deleteUser(pk);
	}

	public RoleModel readRole(Integer pk) {
		return repository.readRole(pk);
	}

	public RoleModel setRole(Integer pk, Integer rpk) {
		return repository.setRole(pk, rpk);
	}

	public UserModel deleteRole(Integer pk) {
		return repository.deleteRole(pk);
	}

}
