package proj.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeRequests(auth -> {
//                    auth.requestMatchers("/api/v1/sign-up").permitAll();
//                    auth.requestMatchers("/api/v1/user/admin/**").hasRole("ADMIN");
//                    auth.requestMatchers("/api/v1/user/**").authenticated();
//                    auth.requestMatchers("/api/v1/user/cashier/**").hasRole("CASHIER");
//                })
//                .httpBasic(Customizer.withDefaults())
//                .build();
        return http
                .csrf().disable()
                .cors().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .build();
    }
}