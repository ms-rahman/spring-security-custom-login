package io.javabrains.springsecuritycustomlogin;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Show your own Login Page
        // Login Processing URL
        // Default Success URL
        // Failure URL
        // Success Forward URL
        // Failure Forward URL
        // Success Handler
        // Failure Handler
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
//                .loginProcessingUrl("/processLogin") @TODO
                .defaultSuccessUrl("/home")
//                .failureUrl("authFailureUrl")@TODO
//                .successForwardUrl("/forward")@TODO
//                .failureForwardUrl("/failure")@TODO
//                .successHandler(new SimpleUrlAuthenticationSuccessHandler())@TODO
//                .failureHandler(new AuthenticationEntryPointFailureHandler())@TODO
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login");
    }
}
