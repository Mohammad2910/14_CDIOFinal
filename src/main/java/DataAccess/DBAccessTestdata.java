package DataAccess;

public class DBAccessTestdata {
    public static void main(String[] args) {
        try{
            DBAccess dbAccess = new DBAccess();
            output(dbAccess.getUserName(dbAccess.connection,"1212993113"));
            output(dbAccess.getUserName(dbAccess.connection,"2004891337"));
            DBAccess dbAccess1 = new DBAccess();
            output(dbAccess1.getUserName(dbAccess.connection,"1212993113"));
            output(dbAccess1.getAllUsers(dbAccess1.connection));
            output(dbAccess.getUserRole(dbAccess.connection,"2004891337"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void output(String[][] str){
        for (String[] strings : str) {
            for (int j = 0; j < strings.length - 1; j++) {
                System.out.println(strings[j]);
            }
            System.out.println();
        }
    }
}
