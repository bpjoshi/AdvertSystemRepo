package com.bpjoshi.advertsys.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * @author Bhagwati Prasad - write2bpj@gmail.com
 *  */
public class Advert {
	private int id;
	
	@Size(min=5, max=60, message="The name must Be between 5 to 60 characters.")
	private String name;
	
	@NotNull
	//@Pattern(regexp=".*\\@.*\\..*", message="This doesn't seem to be a valid email.")
	@Email(message="This is not a valid email address.")
	private String email;
	@Size(min=10, max=250, message="The advert must be between 10 to 250 characters.")
	private String advert;
	
	public Advert() {
		super();
	}

	public Advert(String name, String email, String advert) {
		super();
		this.name = name;
		this.email = email;
		this.advert = advert;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdvert() {
		return advert;
	}

	public void setAdvert(String advert) {
		this.advert = advert;
	}

	@Override
	public String toString() {
		return "Advert [name=" + name + ", email=" + email + "]";
	}
	
	
}
