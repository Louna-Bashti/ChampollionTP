package champollion;

public class ServicePrevu {

    private int volumeCM;
    private int volumeTD;
    private int volumeTP;

    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
    }

    public int getVolumeCM() {
        return volumeCM;
    }
    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }
    public int getVolumeTD() {
        return volumeTD;
    }
    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }
    public int getVolumeTP() {
        return volumeTP;
    }
    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }

    //renvoie le service prévu de l'enseignant en fonction de l'équivalent TD

    public int serviceTotal() {
        int serviceTotal = (int)Math.round(getVolumeCM()*1.5 + getVolumeTD() + getVolumeTP()*0.75);
        return serviceTotal;
    }



}
