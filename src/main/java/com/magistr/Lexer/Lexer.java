package com.magistr.Lexer;

import java.util.Scanner;

import com.magistr.Scanner.CustomCharacter;
import com.magistr.Scanner.CustomScanner;

public class Lexer {
private CustomScanner cs;
private Character c1;
private String c2;
private CustomCharacter character;
	
	public Lexer(String sourceText) throws Exception{		
		cs = new CustomScanner(sourceText);
		getChar();
	}

	
	public Token get() {		
		return new Token(character);
	}
	
	private void getChar(){
		character = cs.get();
		c1 = character.getCargo();
		c2 = c1 + cs.lookahead(1);
	}
	
	
}
