package BusinessLogic;

import Core.DTO_Bruger;
import DataAccess.DAO_Bruger;
import DataAccess.IDAO_Bruger;


import java.sql.SQLException;
import java.util.List;

public class BLL_Bruger implements I_BLL_Bruger {
    private IDAO_Bruger daoBru = new DAO_Bruger();

    @Override
    public DTO_Bruger opretEnkelBruger(DTO_Bruger enkelBruger) throws SQLException {
        int måned = Integer.parseInt(enkelBruger.getCprNr().substring(2,4));
        System.out.println(måned);
        int dag = Integer.parseInt(enkelBruger.getCprNr().substring(0,2));
        System.out.println(dag);
        int år = Integer.parseInt(enkelBruger.getCprNr().substring(4,6));
        System.out.println(år);
        if (måned == 1 | måned == 3 | måned == 5 | måned == 7 | måned == 8 | måned == 10 | måned == 12) {
            if (dag >= 1 && dag <= 31) {
                return daoBru.opretEnkelBruger(enkelBruger);
            }
        } else if (måned == 4 | måned == 6 | måned == 9 | måned == 11 ) {
            if (dag >= 1 && dag <= 30) {
                return daoBru.opretEnkelBruger(enkelBruger);
            }
        } else if (måned == 2) {
            if ((år % 4) == 0) {
                if (dag >= 1 && dag <= 29) {
                    return daoBru.opretEnkelBruger(enkelBruger);
                }
            } else {
                if (dag >= 1 && dag <= 28) {
                    return daoBru.opretEnkelBruger(enkelBruger);
                }
            }
        }
        throw  new SQLException();
    }

    @Override
    public DTO_Bruger visEnkelBruger(String CPR) throws SQLException {
        return daoBru.laesEnkelBrugerId(CPR);
    }


    @Override
    public void redigerBruger(DTO_Bruger nyeBruger) throws SQLException {
        daoBru.redigerBruger(nyeBruger);
    }

    @Override
    public void sletBruger(String CPR) throws SQLException {
        daoBru.fjernBruger(CPR);
    }

    @Override
    public List<DTO_Bruger> visAlleBrugere() throws SQLException {
        return daoBru.visAlleBrugere();
    }
}
