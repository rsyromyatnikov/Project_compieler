package com.magistr.Scanner;

import java.util.List;

public class ScannerDriver {

	public static void main(String[] args) throws Exception{	
		CustomScanner cs = new CustomScanner();
		List<CustomCharacter> characters = cs.getCharactersFromFile("D:\\text.txt");
		for (CustomCharacter s:characters){
			System.out.println(s.toString());
		}	
	}	
	
}
