package com.magistr.Parser;

import java.util.ArrayList;
import java.util.List;

import com.magistr.Lexer.Lexer;
import com.magistr.Lexer.Symbols;
import com.magistr.Lexer.Token;

public class Parser {
	
	
	private Lexer lx;
	private Node ast;
	private Token token = null;
	private boolean verbose = false;
	private int indent = 0;
	private List<String> numberOperator = new ArrayList<String>();
	
	public Parser(String sourceText) throws Exception{
		lx = new Lexer(sourceText);
		initNumberOperator();
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
	
	public void error(String msg){
		try {
			token.abort(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean foundOneOf(List<String> argTokenTypes){
		for (String argTokenType:argTokenTypes){
			if (token.getType() == argTokenType){
				return true;
			}
		}
		return false;
	}
	
	public boolean found(String argTokenType){
		if (token.getType() == argTokenType){
			return true;
		}
		return false;
	}
	
	public void consume(String argTokenType){
		if (token.getType() == argTokenType){
			getToken();
		}else {
			error("Expected to find" + argTokenType + " but found "+ token.getType());
		}
	}
	
	public Node parse(boolean verbose){
		getToken();
		program();
		if (verbose){
			System.out.println(mulString("~", 80));
			System.out.println("Successful parse!");
			System.out.println(mulString("~", 80));		
		}
		return ast;	
	}
	
	public void program(){
		Node node = new Node(null);
		statement(node);
		while (!found(Symbols.EOF)){
			statement(node);
		}
		consume(Symbols.EOF);
		ast = node;
	}
	
	public void statement(Node node){
		if (found("print")){
			printStatement(node);
		}else {
			assignmentStatement(node);
		}
	}
	
	public void expression(Node node){
		if (found(Symbols.STRING)){
			stringLiteral(node);
			while (found("||")){
				getToken();
				stringExpression(node);
			}
		} else if (found(Symbols.NUMBER)){
			numberLiteral(node);
			while (foundOneOf(numberOperator)){
				node.add(token);
				getToken();
				numberExpression(node);
			}
		} else {
			node.add(token);
			consume(Symbols.IDENTIFIER);
			if (found("||")){
				while (found("||")){
					getToken();
					stringExpression(node);
				}
			} else if (foundOneOf(numberOperator)){
				while(foundOneOf(numberOperator)){
					node.add(token);
					getToken();
					numberExpression(node);
				}
			}
		}
	}
	
	public void assignmentStatement(Node node){
		Node identifierNode = new Node(token);
		consume(Symbols.IDENTIFIER);
		Node operatorNode = new Node(token);
		consume("=");
		node.addNode(operatorNode);
		operatorNode.addNode(identifierNode);
		expression(operatorNode);
		consume(";");
	}
	
	public void printStatement(Node node){
		Node statementNode = new Node(token);
		consume("print");		
		node.addNode(statementNode);
		expression(statementNode);
		consume(";");
	}
	
	public void stringExpression(Node node){
		if (found(Symbols.STRING)){
			node.add(token);
			getToken();
			while(found("||")){
				getToken();
				stringExpression(node);
			}
		}else {
			node.add(token);
			consume(Symbols.IDENTIFIER);
		}
		while(found("||")){
			getToken();
			stringExpression(node);
		}
	}
	
	public void numberExpression(Node node){
		if (found(Symbols.NUMBER)){
			numberLiteral(node);
		} else {
			node.add(token);
			consume(Symbols.IDENTIFIER);
		}
		while (foundOneOf(numberOperator)){
			node.add(token);
			getToken();
			numberExpression(node);
		}
	}
	
	public void stringLiteral(Node node){
		node.add(token);
		getToken();
	}
	
	public void numberLiteral(Node node){
		node.add(token);
		getToken();
	}	
	
	private static String mulString(String s, int times){
   	 String buf= "";
   	 for (int i=0;i< times; i++){
   		 buf+=s;
   	 }   	 
   	 return  buf;    	 
    }

	private void initNumberOperator(){
		numberOperator.add("+");
		numberOperator.add("-");
		numberOperator.add("/");
		numberOperator.add("*");
	}
	
	
	
}
