package com.cooksys.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.cooksys.springboot.Defs.*;

@Entity
@Table(name=ROLE_TABLENAME)
public class RoleModel {
	private static final String ROLE_COLUMN = "role";

	@Column(name=ROLE_COLUMN)
	private String role;

	@Id
	@GeneratedValue //(strategy = GenerationType.IDENTITY)
	private Integer id;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
