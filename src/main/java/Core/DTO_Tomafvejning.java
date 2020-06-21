package Core;

public class DTO_Tomafvejning {
    private int produktBatchID;
    private String raavareNavn;
    private double nonNetto;
    private double tolerance;

    public DTO_Tomafvejning(int produktBatchID, String raavareNavn, double nonNetto, double tolerance) {
        this.produktBatchID = produktBatchID;
        this.raavareNavn = raavareNavn;
        this.nonNetto = nonNetto;
        this.tolerance = tolerance;
    }

    public int getProduktBatchID() {
        return produktBatchID;
    }

    public void setProduktBatchID(int produktBatchID) {
        this.produktBatchID = produktBatchID;
    }

    public String getRaavareNavn() {
        return raavareNavn;
    }

    public void setRaavareNavn(String raavareNavn) {
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

    @Override
    public String toString() {
        return "DTO_Tomafvejning{" +
                "produktBatchID=" + produktBatchID +
                ", raavareNavn='" + raavareNavn + '\'' +
                ", nonNetto=" + nonNetto +
                ", tolerance=" + tolerance +
                '}';
    }
}
