package Core;

public class DTO_Afvejning {
    private double tara;
    private double netto;
    private int raavareBatchID;
    private String cpr;
    private int produktBatchID;
    private String timestamp;


    public DTO_Afvejning(double tara, double netto, int raavareBatchID, String cpr, int produktBatchID, String timestamp) {
        this.tara = tara;
        this.netto = netto;
        this.raavareBatchID = raavareBatchID;
        this.cpr = cpr;
        this.produktBatchID = produktBatchID;
        this.timestamp = timestamp;
    }

    public double getTara() {
        return tara;
    }

    public void setTara(double tara) {
        this.tara = tara;
    }

    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }

    public int getRaavareBatchID() {
        return raavareBatchID;
    }

    public void setRaavareBatchID(int raavareBatchID) {
        this.raavareBatchID = raavareBatchID;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public int getProduktBatchID() {
        return produktBatchID;
    }

    public void setProduktBatchID(int produktBatchID) {
        this.produktBatchID = produktBatchID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "DTO_Afvejning{" +
                "tara=" + tara +
                ", netto=" + netto +
                ", raavareBatchID=" + raavareBatchID +
                ", cpr='" + cpr + '\'' +
                ", produktBatchID=" + produktBatchID +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
