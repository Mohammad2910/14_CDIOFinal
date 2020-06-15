package Core;

public class RaavareDTO {
    private int råvareID;
    private String råvareNavn;

    public RaavareDTO(int råvareID, String råvareNavn){
        this.råvareID = råvareID;
        this.råvareNavn = råvareNavn;
    }

    public int getRåvareID() {
        return råvareID;
    }

    public String getRåvareNavn() {
        return råvareNavn;
    }

    public void setRåvareID(int råvareID) {
        this.råvareID = råvareID;
    }

    public void setRåvareNavn(String råvareNavn) {
        this.råvareNavn = råvareNavn;
    }

    @Override
    public String toString() {
        return "RaavareDTO{" +
                "raavareID=" + råvareID +
                ", raavareNavn='" + råvareNavn + '\'' +
                '}';
    }
}
