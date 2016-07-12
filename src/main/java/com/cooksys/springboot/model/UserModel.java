package com.cooksys.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static com.cooksys.springboot.Defs.*;

@Entity
@Table(name=USER_TABLENAME)
public class UserModel {
	private static final String NAME_COLUMN = "name";
	private static final String CITY_COLUMN = "city";
	private static final String STATE_COLUMN = "state";
	//private static final String ROLE_FK_COLUMN = "role_id";

	@Column(name=NAME_COLUMN)
	private String name;
	@Column(name=CITY_COLUMN)
	private String city;
	@Column(name=STATE_COLUMN)
	private String state;

	@ManyToOne
	@JoinColumn(name=ROLE_TABLENAME)
	private RoleModel rolemodel;
	
	@Id
	@GeneratedValue //(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public UserModel() {
	}
	public UserModel(String name, String city, String state) {
		this.name = name;
		this.city = city;
		this.state = state;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RoleModel getRolemodel() {
		return rolemodel;
	}
	public void setRolemodel(RoleModel rolemodel) {
		this.rolemodel = rolemodel;
	}
	
}

