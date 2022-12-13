package champollion;

public class UE {
    private final String myIntitule;
    private int myHeuresCM;
    private int myHeuresTD;
    private int myHeuresTP;

    public UE(String intitule) {
        myIntitule = intitule;

    }

    public UE(String intitule, int heuresCM, int heuresTD, int heuresTP) {
        myIntitule = intitule;
        myHeuresCM = heuresCM;
        myHeuresTD = heuresTD;
        myHeuresTP = heuresTP;

    }

    public String getIntitule() {
        return myIntitule;
    }
    public int getMyHeuresCM() {
        return myHeuresCM;
    }
    public int getMyHeuresTD() {
        return myHeuresTD;
    }
    public int getMyHeuresTP() {
        return myHeuresTP;
    }

    public void setMyHeuresCM(int myHeuresCM) {
        this.myHeuresCM = myHeuresCM;
    }

    public void setMyHeuresTD(int myHeuresTD) {
        this.myHeuresTD = myHeuresTD;
    }

    public void setMyHeuresTP(int myHeuresTP) {
        this.myHeuresTP = myHeuresTP;
    }
}

