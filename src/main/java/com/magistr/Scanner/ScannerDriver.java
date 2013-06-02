package com.magistr.Scanner;

public class ScannerDriver {

	public static void main(String[] args) throws Exception{	
		CustomScanner cs = new CustomScanner("D:\\text.txt");		
		CustomCharacter character = cs.getChar();		
		while(true){			
			System.out.println(character.toString());			
			if (character.getCargo() == CustomCharacter.ENDMARK) break;
			character = cs.getChar();	
		}
	}	
	
}
