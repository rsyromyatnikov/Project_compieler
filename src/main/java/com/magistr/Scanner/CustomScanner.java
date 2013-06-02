package com.magistr.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CustomScanner {	
	private static final char ENDMARK = '\0';

	public CustomScanner() {}
 
	public List<CustomCharacter> getCharactersFromFile(String filePath) throws Exception {
		
		List<CustomCharacter> characters = new ArrayList<CustomCharacter>();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        String everything = sb.toString(); 
	        int index = -1;
	        int lastIndex = everything.length()-1;
	        int lineIndex = 0;
	        int colIndex = -1;	              
	        
	        for (int i=0; i< everything.length()-1; i++) { 
	        	index++;	        	
	        	if (index>0){
	        		if (everything.charAt(i-1) == '\n'){
	        			lineIndex++;
	        			colIndex = -1;
	        		}
	        	}
	        	colIndex++;
	        	if (index > lastIndex){
	        		characters.add(new CustomCharacter(ENDMARK,index,lineIndex,colIndex)); 	
	        	} else {
	        		characters.add(new CustomCharacter(everything.charAt(i),index,lineIndex,colIndex)); 	
	        	} 	       
	        }    
	    } finally {
	        br.close();
	    }		
		return characters;
	}
	
	
}
