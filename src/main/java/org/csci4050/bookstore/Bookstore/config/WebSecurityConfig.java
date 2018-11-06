package org.csci4050.bookstore.Bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Several different resources were used to realize this configuration:
 * http://www.mkyong.com/spring-security/spring-security-form-login-using-database/
 * https://howtodoinjava.com/spring5/security5/security-java-config-enablewebsecurity-example/
 * https://www.boraji.com/spring-security-5-jdbc-based-authentication-example
 *
 * @author John Michael Kovachi
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled"
                        + " from users where username=?")
                .authoritiesByUsernameQuery("select username, authority "
                        + "from authorities where username=?")
                .passwordEncoder(new PasswordEncoder() {
                    // temporary solution here. Use BCrypt when user service is added.
                    @Override
                    public String encode(CharSequence charSequence) {
                        return charSequence.toString();
                    }

                    @Override
                    public boolean matches(CharSequence charSequence, String s) {
                        return charSequence.toString().equals(s);
                    }
                });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/cart").hasRole("USER") // example of a pattern that could be used for auth
                .antMatchers("/**").hasAnyRole("ADMIN", "USER")
                .and()
                .httpBasic(); // Authenticate users with HTTP basic authentication
    }
}