package com.magistr.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;


public class ScannerDriver {

	public static void main(String[] args) throws Exception{		
		String sourceText = getSourceText("D:\\text.txt");		
		CustomScanner cs = new CustomScanner(sourceText);		
		CustomCharacter character = cs.get();		
		while(true){			
			System.out.println(character.toString());			
			if (character.getCargo() == CustomCharacter.ENDMARK) break;
			character = cs.get();	
		}
	}
	
	private static String getSourceText(String path) throws Exception{
		String sourceText;
		BufferedReader br = new BufferedReader(new FileReader(path));	
		try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        sourceText = sb.toString(); 
		 } finally {
		        br.close();
		 }
		return sourceText;
	}
	
}
