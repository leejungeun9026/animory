package com.four.animory.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 웹 보안기능 활성화
@RequiredArgsConstructor
@Log4j2
public class CustomSecurityConfig {
  // 인증, 인가 설정
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    log.info("--------------------configure--------------------");
    return http
        .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
        .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.disable())
        .authorizeHttpRequests(authorizeRequest -> authorizeRequest
            .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//            .requestMatchers("/login", "/user/**", "/", "/comments/**", "/home").permitAll()
//            .requestMatchers(HttpMethod.GET, "/board/**").permitAll()
//            .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
            .requestMatchers("/**").permitAll()
            .requestMatchers("/").permitAll()
            .anyRequest().authenticated())
        .formLogin(formLoginConfigure -> formLoginConfigure
            .loginPage("/user/login")
            .loginProcessingUrl("/loginProcess")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/", true)
            .permitAll())
        .logout(logoutConfigure -> logoutConfigure
            .logoutUrl("/user/logout")
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .clearAuthentication(true))
        .build();
  }

  // 비밀번호 암호화
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // 정적 리소스(css, js, images 등)을 인증 절차에서 제외
  @Bean
  public WebSecurityCustomizer configurer() {
    return (web->web.ignoring()
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()));
  }
}
