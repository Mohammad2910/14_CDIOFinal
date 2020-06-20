package Core;

public class DTO_ReceptRaavare {
    int receptID;
    double nonNetto;
    double tolerance;
    int raavareID;

    @Override
    public String toString() {
        return "ReceptRaavareDTO{" +
                "receptID=" + receptID +
                ", nonNetto=" + nonNetto +
                ", tolerance=" + tolerance +
                ", raavareID=" + raavareID +
                '}';
    }

    public DTO_ReceptRaavare(int receptID, double nonNetto, double tolerance, int raavareID) {
        this.receptID = receptID;
        this.nonNetto = nonNetto;
        this.tolerance = tolerance;
        this.raavareID = raavareID;
    }

    public void setReceptID(int receptID) {
        this.receptID = receptID;
    }

    public void setNonNetto(double nonNetto) {
        this.nonNetto = nonNetto;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public void setRaavareID(int raavareID) {
        this.raavareID = raavareID;
    }

    public int getReceptID() {
        return receptID;
    }

    public double getNonNetto() {
        return nonNetto;
    }

    public double getTolerance() {
        return tolerance;
    }

    public int getRaavareID() {
        return raavareID;
    }


}
