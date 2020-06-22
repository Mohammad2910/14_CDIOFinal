package Core;

import org.junit.Test;

import static org.junit.Assert.*;

public class DTO_BrugerTest {

    DTO_Bruger bruger = new DTO_Bruger("1234567890", "James Jones", "JJ", "Admin", "Aktiv");


    @Test
    public void getCprNr() {
        assertEquals("1234567890", bruger.getCprNr());
    }

    @Test
    public void getBrugerNavn() {
        assertEquals("James Jones", bruger.getBrugerNavn());
    }


    @Test
    public void getIni() {
        assertEquals("JJ", bruger.getIni());
    }



    @Test
    public void getRolle() {
        assertEquals("Admin", bruger.getRolle());
    }


    @Test
    public void getBrugerStatus() {
        assertEquals("Aktiv", bruger.getBrugerStatus());
    }



    @Test
    public void setCprNr() {
        bruger.setCprNr("0000000000");
        assertEquals("0000000000", bruger.getCprNr());
    }

    @Test
    public void setBrugerNavn() {
        bruger.setBrugerNavn("Lars Larsen");
        assertEquals("Lars Larsen", bruger.getBrugerNavn());
    }

    @Test
    public void setIni() {
        bruger.setIni("LL");
        assertEquals("LL", bruger.getIni());
    }

    @Test
    public void setRolle() {
        bruger.setRolle("Laborant");
        assertEquals("Laborant", bruger.getRolle());
    }


    @Test
    public void setBrugerStatus() {
        bruger.setBrugerStatus("Ikke aktiv");
        assertEquals("Ikke aktiv", bruger.getBrugerStatus());
    }



    @Test
    public void testToString() {
        assertEquals("BrugerDTO{cprNr=1234567890, brugerNavn='James Jones', ini='JJ'," +
                     " rolle=Admin, brugerStatus=Aktiv}", bruger.toString());
    }


}