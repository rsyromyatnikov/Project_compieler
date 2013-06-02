package com.magistr.Scanner;


public class ScannerDriver {

	public static void main(String[] args) throws Exception{	
		CustomScanner cs = new CustomScanner("D:\\text.txt");
		
		CustomCharacter character = cs.getChar();
		System.out.println(character.toString());		
	}	
	
}
