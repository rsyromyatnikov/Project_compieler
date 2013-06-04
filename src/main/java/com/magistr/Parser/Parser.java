package com.magistr.Parser;

import com.magistr.Lexer.Lexer;
import com.magistr.Lexer.Token;

public class Parser {
	
	private Lexer lx;
	private Token token = null;
	private boolean verbose = false;
	private int indent = 0;
	private String[] numberOperator = {"+","-","/","*"};
	
	public Parser(String sourceText) throws Exception{
		lx = new Lexer(sourceText);
	}
	
	public void getToken() {
		if (verbose) {
			System.out.println(mulString(" ",indent) 
					+ "  ("+ token.toString() + ")");
		}
		token = lx.get();
	}
	
	public void push(String s){
		indent+=1;
		if (verbose){
			System.out.println(mulString(" ",indent) + " " +s);
		}
	}
	
	public void pop(String s){
		if (verbose){
			//System.out.println(mulString(" ",indent) + " " +s+ ".end");
		}
		indent -=1;
	}
	
	// track0 method 
	// track method 
	
	
	
	
	
	
	private static String mulString(String s, int times){
   	 String buf= "";
   	 for (int i=0;i< times; i++){
   		 buf+=s;
   	 }   	 
   	 return  buf;    	 
    }

	

	
	
	
}
