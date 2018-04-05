/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Random;

/**
 *
 * @author Teixei_H
 */
public class RandomMdp {

    private int compteur;

    private final int longueurmdp = 8;

    Random rand = new Random();

    private final int max = 126;
    private final int min = 65;

    public String GenMDP() {
        String mdp = "";
        compteur = 0;
        int nombreAleatoire;

        while (compteur < longueurmdp) {
            nombreAleatoire = rand.nextInt(max - min + 1) + min;
            mdp += Character.toString((char) nombreAleatoire);
            compteur++;
        }
        return mdp;
    }

}
