package com.bpjoshi.advertsys.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	
	@NotBlank
	@Size(min=5, max=59)
	@Pattern(regexp = "^\\w{5,}$")
	private String username;
	
	@Email
	private String email;
	
	@NotBlank
	@Pattern(regexp="^\\S+$")
	@Size(min=6, max=20)
	private String password;
	private boolean enabled=false;
	private String authority;
	
	
	public User() {
		super();
	}


	public User(String username, String email, String password, boolean enabled,
			String authority) {
		super();
		this.username = username;
		this.email=email;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
	}
	
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
