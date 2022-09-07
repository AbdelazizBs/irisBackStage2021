package com.iris.irisback.controller;

import com.iris.irisback.dto.OrdreFabricationDTO;
import com.iris.irisback.service.OrdreFabricationService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/ordreFabrication")
@CrossOrigin(origins = "*")
public class OrdreFabricationController {

  final OrdreFabricationService ordreFabricationService;

  public OrdreFabricationController(final OrdreFabricationService ordreFabricationService) {
    this.ordreFabricationService = ordreFabricationService;
  }

  @PostMapping("/addOf")
  public OrdreFabricationDTO lancementOf(
      @RequestParam final Date dateLancement,
      @RequestParam final String debutHeure,
      @RequestParam final String finHeure,
      @RequestParam final String commentaire,
      @RequestParam final String qtePremierChoix,
      @RequestParam final String qteNonConforme) {
    return ordreFabricationService.addOf(
        dateLancement,
        debutHeure,
        finHeure,
        commentaire,
        qtePremierChoix,
        qteNonConforme);
  }
}
