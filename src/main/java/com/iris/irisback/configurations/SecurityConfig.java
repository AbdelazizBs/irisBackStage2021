package com.iris.irisback.configurations;

//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// public class SecurityConfig {
//
//
//    @Configuration
//    @EnableWebSecurity
//    public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//        // @Autowired
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.csrf()
//                    .disable()
//                    .authorizeRequests()
//                    .antMatchers(HttpMethod.OPTIONS, "/**")
//                    .permitAll()
//                    .anyRequest()
//                    .authenticated()
//                    .and()
//                    .httpBasic();
//        }
//
// }
//        //c'est bon on a le declare dans application.properties
//   /* @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws
//            Exception
// {auth.inMemoryAuthentication().withUser("mohamed").password("{noop}1234").roles("USER");
//    }
//
//    }
//
// }
