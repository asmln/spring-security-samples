package ru.cmlt.security.nospringsimple.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anatoly Samoylenko on 17.05.18.
 */
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = -1076203250458630728L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        var outStream = resp.getOutputStream();
        outStream.write(String.format("nospring-simple -> Profile: %s", SecurityUtils.authUserName(req)).getBytes());
        outStream.flush();
        outStream.close();
    }

}