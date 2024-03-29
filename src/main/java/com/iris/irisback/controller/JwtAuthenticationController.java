// package com.iris.irisback.controller;
//
// import com.iris.irisback.configurations.JwtTokenUtil;
// import com.iris.irisback.model.JwtRequest;
// import com.iris.irisback.model.JwtResponse;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.BadCredentialsException;
// import org.springframework.security.authentication.DisabledException;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.web.bind.annotation.*;
//
// @RestController
// @CrossOrigin(origins = "*")
// public class JwtAuthenticationController {
//  private final AuthenticationManager authenticationManager;
//  private final JwtTokenUtil jwtTokenUtil;
//  private final UserDetailsService jwtInMemoryUserDetailsService;
//
//  public JwtAuthenticationController(
//      final AuthenticationManager authenticationManager,
//      final JwtTokenUtil jwtTokenUtil,
//      final UserDetailsService jwtInMemoryUserDetailsService) {
//    this.authenticationManager = authenticationManager;
//    this.jwtTokenUtil = jwtTokenUtil;
//    this.jwtInMemoryUserDetailsService = jwtInMemoryUserDetailsService;
//  }
//
//  @RequestMapping(
//      value = {"/auth"},
//      method = RequestMethod.POST)
//  public ResponseEntity<?> generateAuthenticationToken(
//      @RequestBody final JwtRequest authenticationRequest) throws Exception {
//    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//    final UserDetails userDetails =
//        jwtInMemoryUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//    final String token = jwtTokenUtil.generateToken(userDetails);
//    return ResponseEntity.ok(new JwtResponse(token));
//  }
//
//  private void authenticate(final String username, final String password) throws Exception {
//    try {
//      authenticationManager.authenticate(
//          new UsernamePasswordAuthenticationToken(username, password));
//    } catch (final DisabledException e) {
//      throw new Exception("USER_DISABLED", e);
//    } catch (final BadCredentialsException e) {
//      throw new Exception("INVALID_CREDENTIALS", e);
//    } catch (final Exception e) {
//      e.printStackTrace();
//    }
//  }
// }
