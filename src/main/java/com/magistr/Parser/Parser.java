package com.magistr.Parser;

import java.util.Arrays;
import java.util.List;

import com.magistr.Lexer.Lexer;
import com.magistr.Lexer.Symbols;
import com.magistr.Lexer.Token;

public class Parser {
	
	
	private Lexer lx;
	private Token token = null;
	private List<String> numberOperator = Arrays.asList("+", "-", "/", "*");
	
	public Parser(String sourceText) throws Exception{
		lx = new Lexer(sourceText);
	}	
	
	public Node parse(){
		getToken();		
		return program();	
	}
	
	private void getToken() {
		token = lx.get();
	}
	
	private Node program(){
		Node node = new Node(null);
		statement(node);
		while (!found(Symbols.EOF)){
			statement(node);
		}
		consume(Symbols.EOF);
		return node;
	}
	
	private void consume(String argTokenType){	
		if (token.getType().equalsIgnoreCase(argTokenType)){
			getToken();
		}else {
			error("Expected to find" + argTokenType + " but found "+ token.getType());
		}
	}
	
	private void statement(Node node){
		if (found("print")){
			printStatement(node);
		}else {
			assignmentStatement(node);
		}
	}
	
	private boolean found(String argTokenType){
		if (token.getType().equalsIgnoreCase(argTokenType)){
			return true;
		}
		return false;
	}
	
	private boolean foundOneOf(List<String> argTokenTypes){
		for (String argTokenType:argTokenTypes){
			if (token.getType().equalsIgnoreCase(argTokenType)){
				return true;
			}
		}
		return false;
	}
	
	private void expression(Node node){
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
	
	private void assignmentStatement(Node node){
		Node identifierNode = new Node(token);
		consume(Symbols.IDENTIFIER);
		Node operatorNode = new Node(token);
		consume("=");
		node.addNode(operatorNode);
		operatorNode.addNode(identifierNode);
		expression(operatorNode);
		consume(";");
	}
	
	private void printStatement(Node node){
		Node statementNode = new Node(token);
		consume("print");		
		node.addNode(statementNode);
		expression(statementNode);
		consume(";");
	}
	
	private void stringExpression(Node node){
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
	
	private void numberExpression(Node node){
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
	
	private void stringLiteral(Node node){
		node.add(token);
		getToken();
	}
	
	private void numberLiteral(Node node){
		node.add(token);
		getToken();
	}	
	
	private void error(String msg){
		try {
			token.abort(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
