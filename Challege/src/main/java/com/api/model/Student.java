package com.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	
	 @Id
	private String rut;

   @Column 
   private String name;
   
   @Column 
   private String lastName;
   
   @Column 
   private int age;
   
   @Column 
   private String code;

   public String getRut() {
	return rut;
   }

   public void setRut(String rut) {
	this.rut = rut;
   }

   public String getName() {
	return name;
   }

   public void setName(String name) {
	this.name = name;
   }

   public String getLastName() {
	return lastName;
   }

   public void setLastName(String lastName) {
	this.lastName = lastName;
   }

   public int getAge() {
	return age;
	}

	public void setAge(int age) {
	this.age = age;
	}

	public String getCode() {
	return code;
	}

	public void setCode(String code) {
	this.code = code;
	}
   
   
   
   
   
  
	
}

