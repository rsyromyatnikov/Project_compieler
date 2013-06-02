package com.magistr.Lexer;

import com.magistr.Scanner.CustomCharacter;

public class Token {
 
	private String cargo;
	private Integer lineIndex;
	private Integer colIndex;
	private String type;
	
	public Token(CustomCharacter startChar){
		this.cargo = Character.toString(startChar.getCargo());
		this.lineIndex = startChar.getLineIndex();
		this.colIndex = startChar.getColIndex();
		this.type = null;			
	}	

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString(){
		return "";
	}
}
