package ru.cmlt.security.nospringsimple;

import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * Created by Anatoly Samoylenko on 17.05.18.
 */
public class NospringApplication {

    public static void main(String[] args) throws Exception {

        var tempPath = new File(System.getProperty("java.io.tmpdir"));
        var webAppDir = new File("nospring-simple-security/src/main/webapp/");

        var tomcat = new Tomcat();
        tomcat.setBaseDir(tempPath.getAbsolutePath() + "/tomcat-nsa");
        tomcat.setPort(8080);
        tomcat.getConnector();

        tomcat.addWebapp("", webAppDir.getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
