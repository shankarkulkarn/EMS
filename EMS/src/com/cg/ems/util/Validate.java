package com.cg.ems.util;

public class Validate {

	public static boolean validateName(String employeeName) {
		boolean flag = false;
		
		flag = employeeName.matches("[a-zA-z]+");
		return flag ;
	}
	
	
	
}
