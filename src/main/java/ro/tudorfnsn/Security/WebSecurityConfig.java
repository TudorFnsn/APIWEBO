package ro.tudorfnsn.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserDetailsService userDetailsService;



    @Override
    protected void configure(HttpSecurity http) throws Exception
    {



        http.csrf().disable();


//        restrictWebpageToAdmin(http, "continent");
//        restrictWebpageToAdmin(http, "country");
//        restrictWebpageToAdmin(http, "region");
//        restrictWebpageToAdmin(http, "city");
//        restrictWebpageToAdmin(http, "house");
//        restrictWebpageToAdmin(http, "background");
//
//
//        restrictControllerLocationAdmin(http, "continent");
//        restrictControllerLocationAdmin(http, "country");
//        restrictControllerLocationAdmin(http, "region");
//        restrictControllerLocationAdmin(http, "city");
//        restrictControllerLocationAdmin(http, "house");
//        restrictControllerLocationAdmin(http, "background");
//
//          http.authorizeRequests().antMatchers("/user**").hasAnyRole("ADMIN");

        // DO THE MAPPING
        http.authorizeRequests().antMatchers("/user/**").hasAnyRole("ADMIN");
//
//       http.authorizeRequests().antMatchers("/machine**").hasAnyRole("ADMIN");
//       http.authorizeRequests().antMatchers("/MachinePage/**").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/MachinePage**").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/machine/**").hasAnyRole("ADMIN");

//        http.authorizeRequests().antMatchers(HttpMethod.POST, "/" + controllerName + "/").hasAnyRole(role);
//        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/" + controllerName + "/{id}").hasAnyRole(role);
//        http.authorizeRequests().antMatchers(HttpMethod.POST, "/" + controllerName + "/{id}").hasAnyRole(role);
//        http.authorizeRequests().antMatchers(HttpMethod.GET, "/" + pageName).hasAnyRole(role);


        http.formLogin()
                .loginPage("/")
                .successHandler(new Success())
                .permitAll()
                .and()
                .logout()
                .permitAll();


        http.authorizeRequests().antMatchers("/**").permitAll();


        http.exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {

            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response,
                                 AuthenticationException authException) throws IOException, ServletException
            {
                if (authException != null)
                {
                    response.sendRedirect("/");

                }
            }
        });

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

    }


    private void restrictControllerLocationAdmin(HttpSecurity http, String controllerName) throws Exception
    {
        String adminRole = "ADMIN";
        restrictCreateTo(http, controllerName, adminRole);
        restrictDeleteTo(http, controllerName, adminRole);
        restrictUpdateTo(http, controllerName, adminRole);
        restrictDeleteTo(http, controllerName, adminRole);
    }

    private void restrictCreateTo(HttpSecurity http, String controllerName, String role) throws Exception
    {
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/" + controllerName + "/").hasAnyRole(role);
    }

    private void restrictDeleteTo(HttpSecurity http, String controllerName, String role) throws Exception
    {
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/" + controllerName + "/{id}").hasAnyRole(role);
    }

    private void restrictUpdateTo(HttpSecurity http, String controllerName, String role) throws Exception
    {
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/" + controllerName + "/{id}").hasAnyRole(role);
    }

    private void restrictWebpageToAdmin(HttpSecurity http, String pageName) throws Exception
    {
        String adminRole = "ADMIN";

        restrictWebpageTo(http, pageName, adminRole);
    }

    private void restrictWebpageTo(HttpSecurity http, String pageName, String role) throws Exception
    {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/" + pageName).hasAnyRole(role);
    }
}