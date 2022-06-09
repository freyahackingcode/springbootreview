package com.iris.config;


import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Description:
 * Author: zyq
 * Version: 1.0
 * Create Date Time: 2022/6/5 07:15.
 * Update Date Time:
 *
 * @see
 */
public class MyLocaleResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        String parameter = request.getParameter("language");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(parameter)){
            String[] splits = parameter.split("_");
            locale = new Locale(splits[0], splits[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
