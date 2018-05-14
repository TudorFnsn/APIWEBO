package ro.tudorfnsn.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Success extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{

    public Success()
    {
        super();
        setUseReferer(true);
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException
    {

        response.sendRedirect("/machine");
        clearAuthenticationAttributes(request);
    }

}