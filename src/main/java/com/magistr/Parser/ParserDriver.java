package com.magistr.Parser;

import java.io.BufferedReader;
import java.io.FileReader;

public class ParserDriver {
     public static void main(String[] args) throws Exception{
    	 String sourceText = getSourceText("D:\\text.txt");
    	 Parser parser = new Parser(sourceText);
    	 Node ast = parser.parse();
    	 System.out.println("    ");
    	 System.out.println("Here is th AST: ");
    	 System.out.println("    ");
    	 System.out.println(ast.toString());
    	 
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
