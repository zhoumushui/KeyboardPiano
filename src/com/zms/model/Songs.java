package com.zms.model;

import java.io.Serializable;

public class Songs implements Serializable{
	
	 private static final long serialVersionUID = 1L; 
	private String name;
	private String s ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
			

}
