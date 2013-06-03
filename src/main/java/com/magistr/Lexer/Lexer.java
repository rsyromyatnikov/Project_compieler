package com.magistr.Lexer;

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
		while ( containsChar(c1,Symbols.WHITESPACE_CHARS) || c2 == "/*" ) {
			while (containsChar(c1,Symbols.WHITESPACE_CHARS)){
				Token token = new Token(character);
				token.setType(Symbols.WHITESPACE);
				getChar();
				while ( containsChar(c1,Symbols.WHITESPACE_CHARS) ){
					token.setCargo(c2);
					getChar();
				}
			}
			while (c2 == "/*" ){
				Token token = new Token(character);
				token.setType(Symbols.COMMENT);
				token.setCargo(c2);
				
				getChar();
				getChar();
				
				while (! (c2 == "*/") ){
					if (c1 == CustomCharacter.ENDMARK){
						//token abort;
					}
					token.setCargo(token.getCargo()+ c1);
					getChar();
				}
				token.setCargo(token.getCargo()+ c2);
				
				getChar();
				getChar();
			}			
		}
		
		Token token = new Token(character);
		
		if (c1 == CustomCharacter.ENDMARK){
			token.setType(Symbols.EOF);
			return token;
		}
		
		if (containsChar(c1,Symbols.IDENTIFIER_STARTCHARS)){
			token.setType(Symbols.IDENTIFIER);
			getChar();
			while(containsChar(c1,Symbols.IDENTIFIER_CHARS)) {
				token.setCargo(token.getCargo()+c1);
				getChar();
			}
			if (Symbols.KEYWORDS.contains(token.getCargo())) {
				token.setType(token.getCargo());
			}
			return token;
		}
		
		if (containsChar(c1,Symbols.NUMBER_STARTCHARS)){
			token.setType(Symbols.NUMBER);
			getChar();
			while(containsChar(c1,Symbols.NUMBER_CHARS)) {
				token.setCargo(token.getCargo()+c1);
				getChar();
			}
			return token;			
		}
		
		if (containsChar(c1,Symbols.STRING_STARTCHARS)){
			Character quoteChar = c1;
			getChar();
			while (c1!=quoteChar){
				if (c1 == CustomCharacter.ENDMARK){
					//token.abort!;
				}
				token.setCargo(token.getCargo()+c1);
				getChar();				
			}
			token.setCargo(token.getCargo()+c1);
			getChar();
			token.setType(Symbols.STRING);
			return token;
			
		}
		
		if (Symbols.TWOCHARACTERSYMBOLS.contains(c2)){
			token.setCargo(c2);
			token.setType(token.getCargo());
			getChar();
			getChar();
			return token;			
		}
		
		if (containsChar(c1,Symbols.ONECHARACTERSYMBOLS)){
			token.setType(token.getCargo());
			getChar();
			return token;			
		}
		
		
		return new Token(character);
	}
	
	private void getChar(){
		character = cs.get();
		c1 = character.getCargo();
		c2 = c1 + cs.lookahead(1);	
	}
	
	public boolean containsChar(char search, String s) {
	    if (s.length() == 0)
	        return false;
	    else
	        return s.charAt(0) == search || containsChar(search, s.substring(1));
	}
}
