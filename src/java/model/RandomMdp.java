/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author Teixei_H
 */
public class RandomMdp {
    
	public String[] listeChar = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
								"O","P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b",
								"c", "d", "e", "f", "g", "h,", "i", "j", "k", "l", "m", "n", "o", "p",
								"q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	
	private int compteur;
	
	private int longueurmdp = 16;
	
	Random rand = new Random();
	
	private int max = 51;
	private int min = 0;
	
	public String GenMDP() {
		String mdp = "";
		compteur = 0;
		int nombreAleatoire;
		
		while(compteur < longueurmdp) {			
			nombreAleatoire = rand.nextInt(max - min + 1) + min;
			mdp += listeChar[nombreAleatoire];
			compteur++;
		}	
		return mdp;
	}
}
