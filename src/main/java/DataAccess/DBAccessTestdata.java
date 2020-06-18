package DataAccess;

import BusinessLogic.BLLReceptRaavare;
import BusinessLogic.I_BLLReceptRaavare;
import Core.RaavareDTO;

import java.util.List;

public class DBAccessTestdata {
    public static void main(String[] args) {
        try{
            I_BLLReceptRaavare dao = new BLLReceptRaavare();
            for (ReceptRaavareDTO d: dao.visAlleReceptRaavarer("2")) {
                System.out.println(d);
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
//
    public static void output(List<RaavareDTO> str){
        for (RaavareDTO d : str) {

            System.out.println(d.toString());
        }
    }
}
