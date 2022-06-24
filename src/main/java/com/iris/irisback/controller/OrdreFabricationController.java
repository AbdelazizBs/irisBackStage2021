package com.iris.irisback.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/ordreFabrication")
@CrossOrigin(origins = "*")
public class OrdreFabricationController {

  /* public  void  lancementOf(@RequestBody ArticleDTO articleDTO){

  }*/

  private Date dateLancement;
  private Date debutHeure;
  private Date finHeure;
  private String commentaire;
  private String quentitePremierChoix;
  private String quentiteNonConforme;
}
