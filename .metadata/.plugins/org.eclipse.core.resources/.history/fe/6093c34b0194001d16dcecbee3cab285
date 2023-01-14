package com.model;

import java.util.Date;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@Entity 
public class Student {
	
	@NotBlank(message = "name is mandatory")
	@Pattern(regexp = "^[a-zA-Z ]{6,12}$",
            message = "format incorrecr")
	private String name;
	@NotBlank(message = "mobile nub is mandatory")
	@Pattern(regexp = "^[0-9]{6,12}$",
    message = "format incorrecr")
	private String mobileno;
	@Id
	@GeneratedValue
	private int id;
	
			
	     @NonNull
	     @NotBlank(message = "New password is mandatory")
	private String pwd;
	     @NotBlank(message = "New password is mandatory")
	private String repwd;
	     @NotBlank(message = " gmail is mandatory")
	     @Email(message="incorrect format")
	     @Column(unique=true)

	private String gmail;
//	private Date currentDate=new Date(System.currentTimeMillis());
	     @NotBlank(message = "New username is mandatory")
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
//	public Date getCurrentDate() {
//		return currentDate;
//	}
//	public void setCurrentDate(Date currentDate) {
//		this.currentDate = currentDate;
//	}
	public Student(String name, String mobileno, int id, String pwd, String repwd, String gmail,
			String username) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.id = id;
		this.pwd = pwd;
		this.repwd = repwd;
		this.gmail = gmail;
		
		this.username = username;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", mobileno=" + mobileno + ", id=" + id + ", pwd=" + pwd + ", repwd=" + repwd
				+ ", gmail=" + gmail + ", currentDate=" + ", username=" + username + "]";
	}
	
}
