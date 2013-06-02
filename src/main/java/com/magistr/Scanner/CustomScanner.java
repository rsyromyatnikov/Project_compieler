package com.magistr.Scanner;


public class CustomScanner {	
	
	private String sourceText;
	private int sourceIndex;
    private int lineIndex;
    private int colIndex;
    private int lastIndex;
    

	public CustomScanner(String sourceText) {
		this.sourceText = sourceText;
		this.lastIndex = sourceText.length()-1;
		this.sourceIndex = -1;
		this.lineIndex = 0;
		this.colIndex = -1;
	}
 
	public CustomCharacter get()  {
		CustomCharacter customCharacter;        
		sourceIndex++;	        	
	    if (sourceIndex>0){
	        if (sourceText.charAt(sourceIndex-1) == '\n'){
	        	lineIndex++;
	        	colIndex = -1;
	        }
	    }
	    colIndex++;
	    if (sourceIndex > lastIndex){
	        customCharacter = new CustomCharacter(CustomCharacter.ENDMARK,sourceIndex,lineIndex,colIndex); 	
	    } else {
	    	Character c = sourceText.charAt(sourceIndex);
	        customCharacter = new CustomCharacter(c,sourceIndex,lineIndex,colIndex); 	
	    }   
		return customCharacter;
	}
	
	public String lookahead(int offset) {
		int index = sourceIndex + offset;
		if (index > lastIndex){
			return Character.toString(CustomCharacter.ENDMARK);
		} else {
			return Character.toString(sourceText.charAt(index));
		}
		
	}
	
	
}
