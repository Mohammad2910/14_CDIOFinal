import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

//styrer tomcat ( kan starte projektet op
public class StartTomCat {

    private static Tomcat tomcat;

    public static void main(String[] args) {

        tomcat = new Tomcat();

        tomcat.setBaseDir("temp");
        tomcat.setPort(8081);
        tomcat.getConnector();

        //webcode ( hvis denne skal kører på tomcatten)

        //tilføjer webapp ( kan også også tilføje)
//        try {
            tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }

        try{
            // her prøver vi at starte tomcat ( ligesom at skrive startup i cmd
            tomcat.start();
        }catch (LifecycleException e){
            e.printStackTrace();
        }

        // for at den acynkornt venter på at der sker noget
        tomcat.getServer().await();

    }
}
