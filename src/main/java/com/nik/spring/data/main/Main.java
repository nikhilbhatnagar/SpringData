package com.nik.spring.data.main;

public class Main {

	public static void main(String[] args) {
		String str = "48,80,1.020,1,0,?,normal,notpresent,notpresent,121,36,1.2,?,?,15.4,44,7800,5.2,yes,yes,no,good,no,no,ckd";
		System.out.println(str.substring(0, str.indexOf(",")));
		System.out.println(str.substring(str.indexOf(",")+1, str.length()));
	}
}
