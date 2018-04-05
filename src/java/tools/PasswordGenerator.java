/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Random;

/**
 * Génère un mot de passe aléatoire.
 *
 * @author Teixei_H
 */
public class PasswordGenerator {

    private Random rand = new Random();

    private final int LONGUEUR_MDP = 8;
    private final String CHARS
            = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-.";

    /**
     * Génère un mot de passe aléatoire de LONGUEUR_MDP caractères. Les
     * caractères peuvent être des lettres en majuscule ou minuscule sans
     * accent, des chiffres, le point, le tiret ou le souligné.
     *
     * @return
     */
    public String getRandomPassword() {
        StringBuilder sb = new StringBuilder();

        for (int compteur = 0; compteur < LONGUEUR_MDP; compteur++) {
            int nombreAleatoire = rand.nextInt(CHARS.length());
            sb.append(CHARS.charAt(nombreAleatoire));
        }
        return sb.toString();
    }

}
