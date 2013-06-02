package com.magistr.Lexer;

public class Token {
 
	private Character startChar;
	private Integer lineIndex;
	private Integer colIndex;
	private String type;
	
	public Token(Character startChar,Integer lineIndex,Integer colIndex, String type){
		this.startChar = startChar;
		this.lineIndex = lineIndex;
		this.colIndex = colIndex;
		this.type = type;		
	}
	
	
	public Character getStartChar() {
		return startChar;
	}

	public void setStartChar(Character startChar) {
		this.startChar = startChar;
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
