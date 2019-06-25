package Ordermanager.Testing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().and().authorizeRequests().anyRequest().permitAll()
                .antMatchers("api/user/getAll").permitAll()
                .antMatchers("api/user/getById").access("hasRole('USER')")
                .antMatchers("api/user/add").access("hasRole('USER')")
                .antMatchers("api/user/update").access("hasRole('USER')")
                .antMatchers("api/user/delete").access("hasRole('USER')")
                  .antMatchers("api/user/deleteAll").access("hasRole('USER')")

                .antMatchers("api/addToWish").access("hasRole('USER')")
                .antMatchers("api/addToOwnProducts").access("hasRole('USER')")
                .antMatchers("api/comment/add").access("hasRole('USER')")
                .antMatchers("api/order").access("hasRole('USER')")

                .antMatchers("api/category/getAll").access("hasRole('ADMIN')")
                .antMatchers("api/category/getById").access("hasRole('USER')")
                .antMatchers("api/category/add").access("hasRole('USER')")
                .antMatchers("api/category/update").access("hasRole('USER')")
                .antMatchers("api/category/delete").access("hasRole('USER')")
                .antMatchers("api/category/deleteAll").access("hasRole('USER')")

                .antMatchers("api/comment/getAll").access("hasRole('USER')")
                .antMatchers("api/comment/getById").access("hasRole('USER')")
                .antMatchers("api/comment/update").access("hasRole('USER')")
                .antMatchers("api/comment/delete").access("hasRole('USER')")
                .antMatchers("api/comment/deleteAll").access("hasRole('USER')")


                .antMatchers("api/product/getById").access("hasRole('USER')")
                .antMatchers("api/product/add").access("hasRole('USER')")
                .antMatchers("api/product/update").access("hasRole('USER')")
                .antMatchers("api/product/delete").access("hasRole('USER')")
                .antMatchers("api/product/deleteAll").access("hasRole('USER')")


                .antMatchers("api/registration").permitAll()

                .and()
                .csrf()
                .disable();
    }
}