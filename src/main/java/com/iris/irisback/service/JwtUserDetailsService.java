package com.iris.irisback.service;
//
//import com.iris.irisback.model.Personnel;
//import com.iris.irisback.repository.PersonnelRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
// @Service
// public class JwtUserDetailsService implements UserDetailsService {
//  @Autowired PersonnelRepository personnelRepository;
//
//  @Override
//  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
//    final Personnel personnel = personnelRepository.findPersonnelByName(username);
//    if (personnel == null) return null;
//    final String login = personnel.getCompte().getEmail();
//    final String password = personnel.getCompte().getPassword();
//    return new User(login, password, null);
//  }
// }
