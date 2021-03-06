package Core;

public class DTO_Recept {
    private int receptID;
    private String receptNavn;

    public DTO_Recept(int receptID, String receptNavn){
        this.receptID = receptID;
        this.receptNavn = receptNavn;
    }

    @Override
    public String toString() {
        return "ReceptDTO{" +
                "receptID=" + receptID +
                ", receptNavn='" + receptNavn + '\'' +
                '}';
    }

    public void setReceptID(int receptID) {
        this.receptID = receptID;
    }

    public void setReceptNavn(String receptNavn) {
        this.receptNavn = receptNavn;
    }

    public int getReceptID() {
        return receptID;
    }

    public String getReceptNavn() {
        return receptNavn;
    }
}
