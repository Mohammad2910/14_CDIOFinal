package Core;

public class RaavareBatchDTO {
    int raavareBatchID;
    double raavareMaengde;
    String leverandoer;
    int raavareID;

    public RaavareBatchDTO(int raavareBatchID, double raavareMaengde, String leverandoer, int raavareID) {
        this.raavareBatchID = raavareBatchID;
        this.raavareMaengde = raavareMaengde;
        this.leverandoer = leverandoer;
        this.raavareID = raavareID;
    }

    @Override
    public String toString() {
        return "RaavareBatch{" +
                "raavareBatchID=" + raavareBatchID +
                ", raavareMaengde=" + raavareMaengde +
                ", leverandoer='" + leverandoer + '\'' +
                ", raavareID=" + raavareID +
                '}';
    }

    public int getRaavareBatchID() {
        return raavareBatchID;
    }

    public void setRaavareBatchID(int raavareBatchID) {
        this.raavareBatchID = raavareBatchID;
    }

    public double getRaavareMaengde() {
        return raavareMaengde;
    }

    public void setRaavareMaengde(double raavareMaengde) {
        this.raavareMaengde = raavareMaengde;
    }

    public String getLeverandoer() {
        return leverandoer;
    }

    public void setLeverandoer(String leverandoer) {
        this.leverandoer = leverandoer;
    }

    public int getRaavareID() {
        return raavareID;
    }

    public void setRaavareID(int raavareID) {
        this.raavareID = raavareID;
    }
}
