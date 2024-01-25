package com.bank.account.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Account {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	private int id;
	@NotBlank(message ="Account name should not be null")
	@Size(min =2,max=8,message ="Acount name should be 1 to 5 char")
	private String name;
	@NotBlank
	private String address;
	@Email
	private String email;
	@Min(50)
	@Max(100)
	private int amount;
	

	public Account(int id, String name, String address, String email, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.amount = amount;
	}
	public Account() {
		super();
		
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
