package rest.example.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //i am intercepting endpoint "/apiParticipant/participantss" from RestController ParticipantController class
        //to check if header parameter that i send via postman is equals to my parameter. If so - continue further
        //with method, if not - send in Postman error message as response... this is security
        //intercepting is managed by filter class that i created for this issue, specifically "ClientFilter.class"

        //comparing, if clientId that comes from request in header is not equals with my clientId
        //i will type error message in postman via response.sendError
        //otherwise, i will continue that method and return appropriate type
        http
                .csrf().disable()
                .antMatcher("/apiParticipant/participantss")
                .addFilterBefore(new ClientFilter(), BasicAuthenticationFilter.class);

    }
}

//nova tabela logEvent koja ce da mi sluzi za logovanje organizer event itd... kad god se doda nov neko od njih
//to mora da se upise u tu logEvent tabelu. ta tabela mora da ima id, description(user has added new participant npr),
//category(add new - posto se radi o dodavanju novog), status(failed ili successful), dateTime(da se upise
//vreme kad se to dodavanje desilo)
//logovati i kada uspe i kada ne uspe(u kodu moram da pitam da li je uspeo ili nije(proveravati vrednost npr)
// ili da li je exception ili nije)

//to radim koristeci aspekt pointcut(tj sve elemente u aspektu) morace @Around
//imacu eventLog repository, tj moracu i model da imam