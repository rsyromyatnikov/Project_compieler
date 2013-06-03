package com.magistr.Lexer;

import java.io.BufferedReader;
import java.io.FileReader;

public class LexerDriver {
	
	
	public static void main (String[] args) throws Exception {
		String sourceText = getSourceText("D:\\text.txt");	
		Lexer lx = new Lexer(sourceText);
		Token token = lx.get();
		
		while (true) {		
			System.out.println(token.toString());
			if (token.getType() == Symbols.EOF){
				break;
			}
			token = lx.get();
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
