package main;

import java.util.LinkedList;

import communication.ParlamentAPIKomunikacija;
import domain.Poslanik;

public class Main {

	public static void main(String[] args){
		LinkedList<Poslanik> lista = (LinkedList<Poslanik>) new ParlamentAPIKomunikacija().vratiPoslanike();
		for (Poslanik poslanik : lista) {
			System.out.println(poslanik);
		}
	}
	
	
}
