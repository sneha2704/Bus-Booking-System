package com.example.busbookingsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;

	@NotEmpty(message = "name is required")
	private String name;

	@Email(message = "Invalid Email")
	@NotBlank(message = "Email Id is mandatory")
	private String emailId;

	@Pattern(regexp = "\\d{10}", message = "Please enter 10 digit phone number")
	private String phoneNumber;

	@Pattern(regexp = "^(?!\\d+$)(?:[a-zA-Z0-9][a-zA-Z0-9 @&$]*)?$", message = "Password must contain atleast 1 uppercase,1 lowercase and 1 digit")
	private String password;
	

	public Admin() {
		super();
	}

	public Admin(int adminId, @NotEmpty(message = "name is required") String name,
			@Email(message = "Invalid Email") @NotBlank(message = "Email Id is mandatory") String emailId,
			@Pattern(regexp = "\\d{10}", message = "Please enter 10 digit phone number") String phoneNumber,
			@Pattern(regexp = "^(?!\\d+$)(?:[a-zA-Z0-9][a-zA-Z0-9 @&$]*)?$", message = "Password must contain atleast 1 uppercase,1 lowercase and 1 digit") String password) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + "]";
	}

	

	
}