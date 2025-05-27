package Jibun.CRUD.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MySpringMvcDispatcherSerlvetIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer { //Это класс для инициализации Spring MVC. настраивает DispatcherServlet (основной сервлет Spring MVC).
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // весь конфиг в SpringConfig
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class}; //Указывает, какой класс содержит конфигурацию Spring MVC
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; //будет обрабатывать все запросы (/).
    }

    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException { //Вызывается при старте приложения.
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext); //Регистрирует HiddenHttpMethodFilter чтобы HTML могли имитировать PATCH, DELETE
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*"); //Добавляет фильтр, который позволяет использовать PATCH, DELETE через скрытое поле _method в формах.
    }
}