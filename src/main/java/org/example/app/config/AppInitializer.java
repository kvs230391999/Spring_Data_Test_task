package org.example.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Необхідно оголосити та зіставити DispatcherServlet
// для обробки всіх запитів.
// https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-servlet.html
// https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-servlet/context-hierarchy.html
// Можна використовувати клас AbstractAnnotationConfigDispatcherServletInitializer
// для реєстрації та програмної ініціалізації DispatcherServlet.
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                AppContext.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
