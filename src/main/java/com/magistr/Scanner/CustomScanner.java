package com.magistr.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;


public class CustomScanner {	
	
	private int index = -1;
    private int lineIndex = 0;
    private int colIndex = -1;
    private String sourceText;

	public CustomScanner(String filePath) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(filePath));	
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
	}
 
	public CustomCharacter getChar()  {
		CustomCharacter customCharacter;        
	    index++;	        	
	    if (index>0){
	        if (sourceText.charAt(index-1) == '\n'){
	        	lineIndex++;
	        	colIndex = -1;
	        }
	    }
	    colIndex++;
	    if (index > sourceText.length()-1){
	        customCharacter = new CustomCharacter(CustomCharacter.ENDMARK,index,lineIndex,colIndex); 	
	    } else {
	        customCharacter = new CustomCharacter(sourceText.charAt(index),index,lineIndex,colIndex); 	
	    }   
		return customCharacter;
	}
	
	
}
