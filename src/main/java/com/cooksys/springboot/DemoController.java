package com.cooksys.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.springboot.model.RoleModel;
import com.cooksys.springboot.model.UserModel;

@RestController
@CrossOrigin(methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.PUT})
public class DemoController {
	
	@Autowired
	DemoService service;
	
	@RequestMapping("/hello")
	String getHello() {
		return service.hello ();
	}

	@RequestMapping(value="/echo", method=RequestMethod.POST)
	String postEcho(@RequestBody String html) {
		return service.echo (html);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	List<UserModel> getUsers() {
		return service.readUsers();
	}

	@RequestMapping(value="/user/{pk}", method=RequestMethod.GET)
	UserModel getUser(@PathVariable Integer pk) {
		return service.readUser(pk);
	}

	@RequestMapping(value="/user", method=RequestMethod.POST)
	UserModel postUser(@RequestBody UserModel usermodel) {
		return service.createUser(usermodel);
	}
	
	@RequestMapping(value="/user/{pk}", method=RequestMethod.PUT)
	UserModel putUser(@PathVariable Integer pk, @RequestBody UserModel usermodel) {
		return service.updateUser(pk, usermodel);
	}
	
	@RequestMapping(value="/user/{pk}", method=RequestMethod.DELETE)
	UserModel deleteUser(@PathVariable Integer pk) {
		return service.deleteUser(pk);
	}
	
	@RequestMapping("/user/{pk}/role")
	RoleModel getRole(@PathVariable Integer pk) {
		return service.readRole(pk);
	}

	@RequestMapping(value="/user/{pk}/role/{rpk}", method=RequestMethod.POST)
	RoleModel postRole(@PathVariable Integer pk, @PathVariable Integer rpk) {
		return service.setRole(pk, rpk);
	}

	@RequestMapping(value="/user/{pk}/role/{rpk}", method=RequestMethod.PUT)
	RoleModel putRole(@PathVariable Integer pk, @PathVariable Integer rpk) {
		return service.setRole(pk, rpk);
	}
	
	@RequestMapping(value="/user/{pk}/role", method=RequestMethod.DELETE)
	UserModel deleteRole(@PathVariable Integer pk) {
		return service.deleteRole(pk);
	}
}
