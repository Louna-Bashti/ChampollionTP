package champollion;

import java.util.ArrayList;
import java.lang.Math;

public class Enseignant extends Personne {

    private ArrayList<UE> listeEnseignements = new ArrayList<UE>();
    private ArrayList<Intervention> listeInterventions = new ArrayList<Intervention>();
    private ServicePrevu service;

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    public Enseignant(String nom, String email, ServicePrevu service) {

        super(nom, email);
        this.service = service;
    }

    public void setService() {
        int heuresCM = 0;
        int heuresTD = 0;
        int heuresTP = 0;
        for(int i=0; i<listeEnseignements.size(); i++) {
            heuresCM = heuresCM + listeEnseignements.get(i).getMyHeuresCM();
            heuresTP = heuresTP + listeEnseignements.get(i).getMyHeuresTP();
            heuresTD = heuresTD + listeEnseignements.get(i).getMyHeuresTD();
        }
        this.service = new ServicePrevu(heuresCM, heuresTD, heuresTP);
    }

    public ServicePrevu getService() {
        return service;
    }


    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {

        int compteurHeures = 0;
        double compteurHeuresDouble = 0;

        for (int i=0; i<listeEnseignements.size(); i++)
        {
            compteurHeuresDouble = compteurHeuresDouble + listeEnseignements.get(i).getMyHeuresCM()*1.5+ listeEnseignements.get(i).getMyHeuresTD() + listeEnseignements.get(i).getMyHeuresTP()*0.75;
        }
        compteurHeures = (int)Math.round(compteurHeuresDouble);
        return compteurHeures;

    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {

        String intitule = ue.getIntitule();
        int compteurHeures = 0;
        double compteurHeuresDouble = 0;

        for (int i=0; i<listeEnseignements.size(); i++)
        {
            if(listeEnseignements.get(i).getIntitule() == intitule) {
                compteurHeuresDouble = compteurHeuresDouble + listeEnseignements.get(i).getMyHeuresCM()*1.5+ listeEnseignements.get(i).getMyHeuresTD() + listeEnseignements.get(i).getMyHeuresTP()*0.75;

            }
        }

        compteurHeures = (int)Math.round(compteurHeuresDouble);
        return compteurHeures;

    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ue.setMyHeuresCM(volumeCM);
        ue.setMyHeuresTD(volumeTD);
        ue.setMyHeuresTP(volumeTP);
        listeEnseignements.add(ue);
        setService();
    }

    /**
     * garde la liste des interventions de chaque enseignant et permet d'en ajouter une
     *
     * @param inter l'intervention concernée
     */

    public void ajouteIntervention(Intervention inter) {
        listeInterventions.add(inter);
    }

    /**
     * Permet de déterminer si le service prévu total de l'enseignant vaut bien 192 heures
     */
    public boolean enSousService() {
        boolean sousService;
        int servicetotal = getService().serviceTotal();
        if (servicetotal < 192) sousService = true;
        else sousService = false;
    }

    /**
     * Permet de déterminer combien d'heures il reste à planifier à l'enseignant pour accomplir ses heures prévues;
     *
     */

    public int resteAPlanifier ()
    {
        int heuresCM = 0;
        int heuresTD = 0;
        int heuresTP = 0;
        for (int i = 0; i<listeInterventions.size(); i++)
        {
            if (listeInterventions.get(i).getType() == TypeIntervention.CM) {heuresCM = (int)Math.round(heuresCM+listeInterventions.get(i).getDuree()*1.5);}
            else if (listeInterventions.get(i).getType() == TypeIntervention.TD) {heuresTD = heuresTD+listeInterventions.get(i).getDuree();}
            else if (listeInterventions.get(i).getType() == TypeIntervention.TP) {heuresTP = (int)Math.round(heuresTP+ listeInterventions.get(i).getDuree()*0.75);}
            }

        int heuresfaites = heuresCM + heuresTP + heuresTD;
        int resteAPlanifier = getService().serviceTotal() - heuresfaites;
        return resteAPlanifier;
    }

}
