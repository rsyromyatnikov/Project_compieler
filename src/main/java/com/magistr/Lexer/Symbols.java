package com.magistr.Lexer;

public class Symbols {
	
	public static String DIGITS = "0123456789";
	public static String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	// a list of keywords
	public static String KEYWORDS = "if then else elif endif while loop endloop print return exit";
	//a list of symbols that are one character long
	public static String ONECHARACTERSYMBOLS = "= ( ) < > / * + - ! & . ;";
	//a list of symbols that are two characters long
	public static String TWOCHARACTERSYMBOLS = "== <= >= <> != ++ ** -- += -= ||";
	
	public static String IDENTIFIER_STARTCHARS = LETTERS;
	public static String IDENTIFIER_CHARS = LETTERS + DIGITS + "_";
	
	public static String NUMBER_STARTCHARS = DIGITS;
	public static String NUMBER_CHARS = DIGITS + ".";
	
	public static String STRING_STARTCHARS = "'" + '"';
	public static String WHITESPACE_CHARS = " \t\n";
	
	//TokenTypes for things other than symbols and keywords	
	
	public static String STRING = "String";
	public static String IDENTIFIER = "Identifier";
	public static String NUMBER = "Number";
	public static String WHITESPACE = "Whitespace";
	public static String COMMENT = "Comment";
	public static String EOF = "Eof";
}
