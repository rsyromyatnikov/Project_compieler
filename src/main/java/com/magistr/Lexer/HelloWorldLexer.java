package com.magistr.Lexer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HelloWorldLexer {

	/**
	 * @param args
	 */
	private static String input_lexemes[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input_lexemes = new String[100];
		String line;
		BufferedReader reader;
		int count=0;
		try {
			reader = new BufferedReader(new FileReader("Input.dat"));
			while ((line = reader.readLine()) != null) {
				int startx=0;
				for(int i=0;i<line.length();i++){
					if(line.charAt(i)==' ' ||line.charAt(i)==';'){
						if (!line.substring(startx, i).equals("")){
							input_lexemes[count++]=line.substring(startx, i);
							startx=i+1;
						}
						
					}
				}
				//if (startx!=line.length()) input_lexemes[count++]=line.substring(startx, line.length());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found\n");
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File not opened\n");
			//e.printStackTrace();
		}
		for(int i=0;i<count;i++){
			System.out.println(i+" "+input_lexemes[i]);
		}
	}

}
