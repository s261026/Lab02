package it.polito.tdp.alien;

import java.util.LinkedList;

public class Parole {
	
	private String parola;
	private String traduzione;
	LinkedList <String> varie ;
	
	public Parole(String parola, String traduzione) {//String traduzione	LinkedList <String> varie

		this.parola = parola;
		this.traduzione = traduzione;
		varie= new LinkedList <String>();
	}
	
	
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public String getTraduzione() {
		return traduzione;
	}
	public void setTraduzione(String traduzione) {
		this.traduzione = traduzione;
	}
	
	public void add(String p){
		varie.add(p);
	}
	

}
