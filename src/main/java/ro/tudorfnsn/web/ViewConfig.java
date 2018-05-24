package ro.tudorfnsn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ViewConfig extends WebMvcConfigurerAdapter
{
    @Autowired
    public ViewConfig(WebpageGenerator webpageGenerator)
    {
        webpageGenerator.init();
    }


    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/machine").setViewName("MachinePage");
        registry.addViewController("/").setViewName("LoginPage");
        registry.addViewController("/spareparts").setViewName("SparePartsPage");
        registry.addViewController("/employee").setViewName("EmployeesPage");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry)
    {

        resourceHandlerRegistry.addResourceHandler("/sources/**").addResourceLocations("classpath:/sources/");
        //resourceHandlerRegistry.addResourceHandler("/Users/mac/WeboApplication/APIWEBO/src/main/resources/templates/**").addResourceLocations("classpath:/resources/templates/");
        //resourceHandlerRegistry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
    }

}
