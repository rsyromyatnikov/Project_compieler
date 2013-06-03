package com.magistr.Lexer;

public class LexerDriver {
	
	
	public static void main (String[] args) {
		String s = "if then else elif endif while loop endloop print return exit";
		String[] b= s.split(" ");
		for (String a:b){
			System.out.println(a);
		}	
	}
}
