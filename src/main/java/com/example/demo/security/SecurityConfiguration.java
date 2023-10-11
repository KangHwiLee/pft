package com.example.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private String[] permitAll = {"/css/**", "/img/**","/js/**","/scss/**","/vendor/**","/register"};
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(permitAll).permitAll()
                .antMatchers("/admin").hasRole("ADMIN")            //권한별 접속 가능 페이지
                .anyRequest().authenticated()			//나머지 접속
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/introduce", true)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll();
        return http.build();
        // configure HTTP security...

    }


//	@Autowired UserDetail userDetail;
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//		auth.userDetailsService(userDetail);
//	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}