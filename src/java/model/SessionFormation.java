package model;

import java.time.LocalDateTime;

public class SessionFormation {

    private int idSession;
    private int idFormation;
    LocalDateTime dateDebut;
    LocalDateTime dateFin;
    private boolean estOuverte;

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public boolean getEstOuverte() {
        return estOuverte;
    }

    public void setEstOuverte(boolean estOuverte) {
        this.estOuverte = estOuverte;
    }

    @Override
    public String toString() {
        return "SessionFormation [idSession=" + idSession + ", idFormation=" + idFormation + ", dateDebut=" + dateDebut
                + ", dateFin=" + dateFin + ", estOuverte=" + estOuverte + "]";
    }

    public SessionFormation(int idSession, int idFormation, LocalDateTime dateDebut, LocalDateTime dateFin,
            boolean estOuverte) {
        this.idSession = idSession;
        this.idFormation = idFormation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.estOuverte = estOuverte;
    }

    public SessionFormation() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
        result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
        result = prime * result + (estOuverte ? 1231 : 1237);
        result = prime * result + idFormation;
        result = prime * result + idSession;
        return result;
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
        SessionFormation other = (SessionFormation) obj;
        if (dateDebut == null) {
            if (other.dateDebut != null) {
                return false;
            }
        } else if (!dateDebut.equals(other.dateDebut)) {
            return false;
        }
        if (dateFin == null) {
            if (other.dateFin != null) {
                return false;
            }
        } else if (!dateFin.equals(other.dateFin)) {
            return false;
        }
        if (estOuverte != other.estOuverte) {
            return false;
        }
        if (idFormation != other.idFormation) {
            return false;
        }
        if (idSession != other.idSession) {
            return false;
        }
        return true;
    }

}
