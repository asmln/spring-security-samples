package ru.cmlt.security.nospringsimple.servlets;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Anatoly Samoylenko on 22.05.18.
 */
public class SecurityUtils {

    public static boolean isAuth(HttpServletRequest request) {
        return request.getUserPrincipal() != null;
    }

    public static String authUserName(HttpServletRequest request) {
        return request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : null;
    }
}
