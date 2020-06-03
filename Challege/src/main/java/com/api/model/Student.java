package com.api.model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
   private int course;
   
   //Validate the check digit
   
	public static String dv ( String rut ) {
		Integer M=0,S=1,T=Integer.parseInt(rut);
		for (;T!=0;T=(int) Math.floor(T/=10))
			S=(S+T%10*(9-M++%6))%11;
		return ( S > 0 ) ? String.valueOf(S-1) : "k";		
	}

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
		if(age<18) {
			throw new java.lang.UnsupportedOperationException("Not supported yet.");
		}
		else
		{
	this.age = age;
		}
	}

	public int setCourse() {
		return course;
	}
   public void setCourse(int course) {
	   this.course=course;
   }
   
   
   
   
  
	
}

