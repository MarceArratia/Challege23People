package com.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

//model reference to all database entities


public class Course {
	
	 @Id
	private int code;

    @Column 
    private String name;
    
   
	public String getName() {
		return name;
	}
                                                                                                
	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public  void setCode(int code) {
		this.code = code;
	}
    
    
	
}
