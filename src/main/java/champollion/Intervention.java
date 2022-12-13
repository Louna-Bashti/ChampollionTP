package champollion;

import java.time.LocalDate;

public class Intervention {

    private LocalDate debut;
    private int duree;
    private boolean annulee = false;
    private int heureDebut;
    private TypeIntervention type;
    private UE ue;
    private Salle salle;

    public Intervention(LocalDate debut, int duree, boolean annulee, int heureDebut, TypeIntervention type, UE ue, Salle salle) {
        this.debut = debut;
        this.duree = duree;
        this.annulee = annulee;
        this.type = type;
        this.heureDebut= heureDebut;
        this.ue = ue;
        this.salle = salle;
    }

    public void isAnnulee() {
        setAnnulee(true);
    }

    public UE getUe() {
        return ue;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }


    // annuler une intervention (doit s'enchaîner sur la suppression de l'intervention du service)

    public void annulerIntervention() {
        setAnnulee(true);
    }
}
