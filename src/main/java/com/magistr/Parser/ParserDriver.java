package com.magistr.Parser;

public class ParserDriver {
     public static void main(String[] args){
    	 System.out.println(mulString("1",1));
     }
     
     private static String mulString(String s, int times){
    	 String buf= "";
    	 for (int i=0;i< times; i++){
    		 buf+=s;
    	 }   	 
    	 return  buf;    	 
     }
}
