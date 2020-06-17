package Core;

import java.util.List;

public class BrugerDTO {

    private String cprNr;
    private String brugerNavn;
    private String ini;
    private String rolle;
    private String brugerStatus;

    public BrugerDTO(String cprNr, String brugerNavn, String ini, String rolle, String brugerStatus) {
        this.cprNr = cprNr;
        this.brugerNavn = brugerNavn;
        this.ini = ini;
        this.rolle = rolle;
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

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public String getBrugerStatus() {
        return brugerStatus;
    }

    public void setBrugerStatus(String brugerStatus) {
        this.brugerStatus = brugerStatus;
    }

    @Override
    public String toString() {
        return "BrugerDTO{" +
                "cprNr=" + cprNr +
                ", brugerNavn='" + brugerNavn + '\'' +
                ", ini='" + ini + '\'' +
                ", rolle=" + rolle +
                ", brugerStatus=" + brugerStatus +
                '}';
    }
}
