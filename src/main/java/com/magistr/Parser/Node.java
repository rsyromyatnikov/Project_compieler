package com.magistr.Parser;

import java.util.ArrayList;
import java.util.List;

import com.magistr.Lexer.Token;

public class Node {
	private Token token;
	private int level;
	private List<Node> children;

	public Node(Token token){
		this.token = token;
		this.level = 0;
		this.children = new ArrayList<Node>(); ;
	}
	
	public void add (Token token){
		addNode(new Node(token));
	}
	
	public void addNode(Node node){
		setLevel(getLevel()+1);
		children.add(node);
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	public String toString(){
		String s = "";
		if (getToken() == null){
			s+= "ROOT\n";
		} else {
			s+= getToken().getCargo() + "\n";
		}
		for (Node n:children){
			s+= n.toString();
		}
		return s;
	}
	
	
	
}
