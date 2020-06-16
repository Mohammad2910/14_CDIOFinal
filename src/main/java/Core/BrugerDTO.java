package Core;

import java.util.List;

public class BrugerDTO {

    private String cprNr;
    private String brugerNavn;
    private String ini;
    private String roller;
    private boolean brugerStatus;


    public BrugerDTO(String cprNr, String brugerNavn, String ini, String roller, boolean brugerStatus) {
        this.cprNr = cprNr;
        this.brugerNavn = brugerNavn;
        this.ini = ini;
        this.roller = roller;
        this.brugerStatus = brugerStatus;
    }

    public String getCprNr() {
        return cprNr;
    }

    public void setCprNr(String cprNr) {
        this.cprNr = cprNr;
    }

    public String getBrugerNavn() {
        return brugerNavn;
    }

    public void setBrugerNavn(String brugerNavn) {
        this.brugerNavn = brugerNavn;
    }

    public String getIni() {
        return ini;
    }

    public void setIni(String ini) {
        this.ini = ini;
    }

    public String getRoller() {
        return roller;
    }

    public void setRoller(String roller) {
        this.roller = roller;
    }

    public boolean isBrugerStatus() {
        return brugerStatus;
    }

    public void setBrugerStatus(boolean brugerStatus) {
        this.brugerStatus = brugerStatus;
    }

    @Override
    public String toString() {
        return "BrugerDTO{" +
                "cprNr=" + cprNr +
                ", brugerNavn='" + brugerNavn + '\'' +
                ", ini='" + ini + '\'' +
                ", roller=" + roller +
                ", brugerStatus=" + brugerStatus +
                '}';
    }
}
