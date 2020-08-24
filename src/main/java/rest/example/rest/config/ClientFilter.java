package rest.example.rest.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;

        //catch header parameter "clientId" that i send as request via Postman
        String compareClientId = httpRequest.getHeader("clientId");

        //my clientId to compare with
        String clientId = "pustaj";

        //comparing, if clientId that comes from request in header is not equals with my clientId
        //i will type error message in postman via response.sendError
        if(clientId.equals(compareClientId)){
            System.out.println("CLIENT ID IS VALID = " + compareClientId);
            filterChain.doFilter(request, response);
        }
        else{
            System.out.println("CLIENT ID IS NOT VALID = " + compareClientId);

            //response.sendError - just for typing error message in postman as response
            httpServletResponse.sendError(400,"Client id is not good or is null");

            //throw new ModelNotFoundException("Client id is not good " + compareClientId);
        }

    }
}
