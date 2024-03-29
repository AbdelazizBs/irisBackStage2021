package com.iris.irisback.configurations;
//
// import com.iris.irisback.service.JwtUserDetailsService;
// import io.jsonwebtoken.ExpiredJwtException;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;
//
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;
//
// @Component
// public class JwtRequestFilter extends OncePerRequestFilter {
//  private final JwtUserDetailsService jwtUserDetailsService;
//  private final JwtTokenUtil jwtTokenUtil;
//
//  public JwtRequestFilter(final JwtUserDetailsService jwtUserDetailsService, final JwtTokenUtil
// jwtTokenUtil) {
//    this.jwtUserDetailsService = jwtUserDetailsService;
//    this.jwtTokenUtil = jwtTokenUtil;
//  }
//
//  @Override
//  protected void doFilterInternal(
//      final HttpServletRequest request, final HttpServletResponse response, final FilterChain
// chain)
//      throws ServletException, IOException {
//    final String requestTokenHeader = request.getHeader("Authorization");
//    String username = null;
//    String jwtToken = null;
//    // JWT Token is in the form "Bearer token". Remove Bearer word and getonly the Token
//    if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer")) {
//      jwtToken = requestTokenHeader.substring(7);
//      try {
//        username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//      } catch (final IllegalArgumentException e) {
//        System.out.println("Unable to get JWT Token");
//      } catch (final ExpiredJwtException e) {
//        System.out.println("JWT Token has expired");
//      }
//    } else {
//      logger.warn("JWT Token does not begin with Bearer String....");
//    }
//    // Once we get the token validate it.
//    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//      final UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
//      // if token is valid configure Spring Security to manually set authentication
//      if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//            new UsernamePasswordAuthenticationToken(
//                userDetails, null, userDetails.getAuthorities());
//        usernamePasswordAuthenticationToken.setDetails(
//            new WebAuthenticationDetailsSource().buildDetails(request));
//        // After setting the Authentication in the context, we specify
//        // that the current user is authenticated. So it passes the Spring Security Configurations
//        // successfully.
//        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//      }
//    }
//    chain.doFilter(request, response);
//  }
// }
