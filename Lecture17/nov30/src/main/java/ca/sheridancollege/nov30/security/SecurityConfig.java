package ca.sheridancollege.nov30.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //if u want a securityconfig u need a password encoder
    //lazy delays the loop (securityconfig + password encode depend on each other --> loops and references each other)m

    //This method allows you to configure authorizations (pages w/roles)
    @Override
    public void configure(HttpSecurity http) throws Exception{
       http.authorizeRequests()
               .antMatchers("/success").hasRole("USER")
               .antMatchers("/seclogin").permitAll()
               .antMatchers("/seclogout").permitAll()
               .and()
               //form login
               .formLogin()
               .loginPage("/seclogin")
               //this is the mapping it goes to if it succeeds/fails
               .defaultSuccessUrl("/success")
               .failureUrl("/error")
               .and()
               .logout()
               //mapping it goes to for the logoutURL
               .logoutUrl("/seclogout")
               //this is the mapping it goes to if it succeeds/fails
               .logoutSuccessUrl("/gologout");
         //https://docs.spring.io/spring-security/reference/servlet/authentication/logout.html
    }

    //we want to adds users
    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("bot")
                .password("123")
                .roles("USER");
    }
    //password encoder
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //https://howtodoinjava.com/spring5/security/login-form-example/


}