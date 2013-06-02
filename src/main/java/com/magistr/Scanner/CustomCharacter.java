package com.magistr.Scanner;

public class CustomCharacter {
	
	private static final Character ENDMARK = '\0';
	private Character cargo;
	private Integer index;
	private Integer lineIndex;
	private Integer colIndex;

	public CustomCharacter(Character cargo,Integer index, Integer lineIndex,Integer colIndex){
		this.cargo = cargo;
		this.index = index;
		this.lineIndex = lineIndex;
		this.colIndex = colIndex;
	}
	
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}	
	
	public Character getCargo() {
		return cargo;
	}

	public void setCargo(Character cargo) {
		this.cargo = cargo;
	}

	public Integer getLineIndex() {
		return lineIndex;
	}

	public void setLineIndex(Integer lineIndex) {
		this.lineIndex = lineIndex;
	}

	public Integer getColIndex() {
		return colIndex;
	}

	public void setColIndex(Integer colIndex) {
		this.colIndex = colIndex;
	}
	
	public String toString() {
		String characterStr = "";
		Character character = getCargo();		
		if (character == ' ') { characterStr = "   space";}
		else if (character == '\n') { characterStr = "   newline";}
		else if (character == '\t') { characterStr = "   tab";}
		else if (character == ENDMARK) { characterStr = "   eof";}
		else {characterStr = Character.toString(getCargo());}
		
		return getLineIndex() + " "
			 + getColIndex() + " " 
		     + characterStr ;
		}		
}
	
	

