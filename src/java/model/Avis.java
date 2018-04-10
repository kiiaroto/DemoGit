/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Ronan
 */
public class Avis {
    
    private int fonctionnalite;
    private int ergonomie;
    private int beaute;
    private String commentaire;
    LocalDateTime date;

   public Avis(){
       
   }

    public Avis(   int fonctionnalite,  int ergonomie, int beaute, String commentaire, LocalDateTime date ) {
        super();
        this. fonctionnalite= fonctionnalite;
        this.ergonomie = ergonomie;
        this.beaute = beaute;
        this.commentaire = commentaire;
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getFonctionnalite() {
        return fonctionnalite;
    }

    public void setFonctionnalite(int fonctionnalite) {
        this.fonctionnalite = fonctionnalite;
    }

    public int getErgonomie() {
        return ergonomie;
    }

    public void setErgonomie(int ergonomie) {
        this.ergonomie = ergonomie;
    }

    public int getBeaute() {
        return beaute;
    }

    public void setBeaute(int beaute) {
        this.beaute = beaute;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.fonctionnalite;
        hash = 97 * hash + this.ergonomie;
        hash = 97 * hash + this.beaute;
        hash = 97 * hash + Objects.hashCode(this.commentaire);
        hash = 97 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avis other = (Avis) obj;
        if (this.fonctionnalite != other.fonctionnalite) {
            return false;
        }
        if (this.ergonomie != other.ergonomie) {
            return false;
        }
        if (this.beaute != other.beaute) {
            return false;
        }
        if (!Objects.equals(this.commentaire, other.commentaire)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    

    

    
    
}
