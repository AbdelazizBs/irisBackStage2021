// package com.iris.irisback.configurations;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
// @Configuration
// @EnableWebSecurity
// @EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true)
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//  //  public SecurityConfig(final UserDetailsService userDetailsService) {
//  //    this.userDetailsService = userDetailsService;
//  //  }
//

//  //  @Override
//  //  protected void configure(@Autowired final AuthenticationManagerBuilder auth) throws
// Exception
//  // {
//  //    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//  //  }
//
//  @Override
//  protected void configure(final HttpSecurity http) throws Exception {
//    http.csrf()
//        .disable()
//        .authorizeRequests()
//        .and()
//        .httpBasic()
//        .and()
//        .authorizeRequests()
//        .anyRequest()
//        .permitAll()
//        .and()
//        .sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//  }
// }
//
//
// import com.iris.irisback.service.JwtUserDetailsService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
// import java.util.Arrays;
//
// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//  @Autowired JwtUserDetailsService jwtUserDetailsService;
//
//  //  @Override
//  //  protected void configure(final AuthenticationManagerBuilder authenticationManagerBuilder)
//  //      throws Exception {
//  //    authenticationManagerBuilder.userDetailsService(jwtUserDetailsService);
//  //  }
//
//  @Override
//  @Bean
//  public AuthenticationManager authenticationManager() throws Exception {
//    return super.authenticationManagerBean();
//  }
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return NoOpPasswordEncoder.getInstance();
//  }
//
//  //  @Override
//  //  protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//  //
//  //    auth.inMemoryAuthentication()
//  //        //            .withUser("user").password("password").roles("USER")
//  //        .withUser("user")
//  //        .password("password")
//  //        .roles("USER")
//  //        .and()
//  //        .withUser("admin")
//  //        .password("password")
//  //        .roles("ADMIN");
//  //  }
//
//  @Bean
//  public CorsConfigurationSource corsConfigurationSource() {
//    final CorsConfiguration configuration = new CorsConfiguration();
//    configuration.setAllowCredentials(true);
//    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//    configuration.setAllowedMethods(Arrays.asList("*"));
//    // configuration.setAllowedHeaders(Arrays.asList("*"));
//    configuration.setAllowedHeaders(Arrays.asList("*"));
//    configuration.setExposedHeaders(Arrays.asList("*"));
//    configuration.setAllowedMethods(Arrays.asList("*"));
//    configuration.addAllowedOriginPattern("*");
//    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", configuration);
//    return source;
//  }
//
//  @Override
//  public void configure(final WebSecurity web) throws Exception {
//    web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//  }
//
//  @Override
//  protected void configure(final HttpSecurity http) throws Exception {
//    http.authorizeRequests()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .formLogin()
//        .loginPage("/login")
//        .permitAll()
//        .and()
//        .logout()
//        .permitAll();
//  }
// }
