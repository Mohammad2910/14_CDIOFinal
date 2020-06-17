package Core;

public class ReceptRaavareDTO {
    private double nonNetto;
    private double tolerance;
    private int receptID;
    private int raavareID;
    private String raavareNavn;

    public ReceptRaavareDTO(int raavareID, double nonNetto, double tolerance, int receptID, String raavareNavn){
        this.nonNetto = nonNetto;
        this.tolerance = tolerance;
        this.receptID = receptID;
        this.raavareID = raavareID;
        this.raavareNavn = raavareNavn;
    }


    public double getNonNetto() {
        return nonNetto;
    }

    public void setNonNetto(double nonNetto) {
        this.nonNetto = nonNetto;
    }

    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public int getReceptID() {
        return receptID;
    }

    public void setReceptID(int receptID) {
        this.receptID = receptID;
    }

    public int getRaavareID() {
        return raavareID;
    }

    public void setRaavareID(int raavareID) {
        this.raavareID = raavareID;
    }

    public String getRaavareNavn() {
        return raavareNavn;
    }

    public void setRaavareNavn(String raavareNavn) {
        this.raavareNavn = raavareNavn;
    }

    @Override
    public String toString() {
        return "ReceptRaavareDTO{" +
                "nonNetto=" + nonNetto +
                ", tolerance=" + tolerance +
                ", receptID=" + receptID +
                ", raavareID=" + raavareID +
                ", raavareNavn='" + raavareNavn + '\'' +
                '}';
    }
}
