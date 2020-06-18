package Core;

public class ProduktBatchDTO {
    int produktBatchID;
    int receptID;
    String status;
    String CPR;
    int raavareBatchID;
    double tara;
    double netto;

    public ProduktBatchDTO(int produktBatchID, int receptID, String status, String CPR, int raavareBatchID, double tara, double netto) {
        this.produktBatchID = produktBatchID;
        this.receptID = receptID;
        this.status = status;
        this.CPR = CPR;
        this.raavareBatchID = raavareBatchID;
        this.tara = tara;
        this.netto = netto;
    }

    @Override
    public String toString() {
        return "ProduktBatchDTO{" +
                "produktBatchID=" + produktBatchID +
                ", receptID=" + receptID +
                ", status='" + status + '\'' +
                ", CPR='" + CPR + '\'' +
                ", raavareBatchID=" + raavareBatchID +
                ", tara=" + tara +
                ", netto=" + netto +
                '}';
    }

    public void setProduktBatchID(int produktBatchID) {
        this.produktBatchID = produktBatchID;
    }

    public void setReceptID(int receptID) {
        this.receptID = receptID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public void setRaavareBatchID(int raavareBatchID) {
        this.raavareBatchID = raavareBatchID;
    }

    public void setTara(double tara) {
        this.tara = tara;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }

    public int getProduktBatchID() {
        return produktBatchID;
    }

    public int getReceptID() {
        return receptID;
    }

    public String getStatus() {
        return status;
    }

    public String getCPR() {
        return CPR;
    }

    public int getRaavareBatchID() {
        return raavareBatchID;
    }

    public double getTara() {
        return tara;
    }

    public double getNetto() {
        return netto;
    }


}
