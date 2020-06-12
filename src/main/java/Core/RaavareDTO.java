package Core;

public class RaavareDTO {
    private int raavareID;
    private String raavareNavn;

    public RaavareDTO(int raavareID, String raavareNavn){
        this.raavareID = raavareID;
        this.raavareNavn = raavareNavn;
    }

    public int getRaavareID() {
        return raavareID;
    }

    public String getRaavareNavn() {
        return raavareNavn;
    }

    public void setRaavareID(int raavareID) {
        this.raavareID = raavareID;
    }

    public void setRaavareNavn(String raavareNavn) {
        this.raavareNavn = raavareNavn;
    }

    @Override
    public String toString() {
        return "RaavareDTO{" +
                "raavareID=" + raavareID +
                ", raavareNavn='" + raavareNavn + '\'' +
                '}';
    }
}
