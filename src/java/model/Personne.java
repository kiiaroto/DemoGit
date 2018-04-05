package model;

import java.util.Objects;

public class Personne {

    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String tel;
    private String adresse;
    private String codePostal;
    private String ville;
    private String motDePasse;

    public Personne() {

    }

    public Personne(int idPersonne, String nom, String prenom, String mail, String tel, String adresse, String codePostal,
            String ville, String motDePasse) {
        super();
        this.id = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.motDePasse = motDePasse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nom);
        hash = 59 * hash + Objects.hashCode(this.prenom);
        hash = 59 * hash + Objects.hashCode(this.mail);
        hash = 59 * hash + Objects.hashCode(this.tel);
        hash = 59 * hash + Objects.hashCode(this.adresse);
        hash = 59 * hash + Objects.hashCode(this.codePostal);
        hash = 59 * hash + Objects.hashCode(this.ville);
        hash = 59 * hash + Objects.hashCode(this.motDePasse);
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
        final Personne other = (Personne) obj;
        if (this.id != other.id) {
            return false;

        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.codePostal, other.codePostal)) {
            return false;
        }
        if (!Objects.equals(this.ville, other.ville)) {
            return false;
        }
        if (!Objects.equals(this.motDePasse, other.motDePasse)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Personne{" + "idPersonne=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + "tel=" + tel + "adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + '}';
    }

}
