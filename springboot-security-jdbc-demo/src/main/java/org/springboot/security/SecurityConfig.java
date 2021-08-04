package org.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
          For authentication (jdbc based)
         */
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT \"USER_NAME\", \"PASSWORD\", \"ENABLED\"\n" +
                        "\tFROM public.\"USER\"\n" +
                        "\tWHERE \"USER_NAME\" = ?")
                .authoritiesByUsernameQuery("SELECT \"USER_NAME\", \"ROLE\"\n" +
                        "\tFROM public.\"USER_ROLE\"\n" +
                        "\tWHERE \"USER_NAME\" = ?");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
          For authorization
         */
        http.authorizeRequests()
                .antMatchers("/user")
                .hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin")
                .hasRole("ADMIN")
                .antMatchers("/")
                .permitAll()
                .and()
                .formLogin();
    }

}
