package com.treinos.launch;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class EmbedTomcatStarter {
    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.setBaseDir(".");
        tomcat.getHost().setAppBase(".");
        tomcat.setSilent(false);

        String webappLocation = new File(webappDirLocation).getAbsolutePath();
        Context ctx = tomcat.addWebapp("/", webappLocation);
        Tomcat.addServlet(ctx, "jsf_servlet", "javax.faces.webapp.FacesServlet");
        ctx.addServletMappingDecoded("*.xhtml", "jsf_servlet");
        tomcat.start();
        tomcat.getServer().await();
    }
}
