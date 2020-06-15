//package DataAccess;
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.startup.Tomcat;
//
//import java.io.File;
//
//public class tomCatConn {
//    // Port to launch server on
//    private static final int PORT = 8080;
//
//    // Relative path from source root
//    private static final String WEBAPP_PATH = "src/main/webapp";
//
//    public static void main(String[] args) throws LifecycleException {
//        Tomcat tomcat = new Tomcat();
//        tomcat.setBaseDir("temp");
//        tomcat.setPort(PORT);
//        tomcat.addWebapp("", new File(WEBAPP_PATH).getAbsolutePath());
//
//        tomcat.getConnector();
//        tomcat.start();
//
//        System.out.println("\n\n" +
//                "If you didn't get an exception during start-up, the TomCat server has started successfully," +
//                "and all applications are ready!" +
//                "\n\n" +
//                "Go to 'localhost:" + PORT + "' in your browser!");
//
//        tomcat.getServer().await();
//    }
//}
//
