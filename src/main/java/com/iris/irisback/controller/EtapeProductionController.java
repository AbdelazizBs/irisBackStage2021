package com.iris.irisback.controller;

import com.iris.irisback.dto.EtapeProductionDTO;
import com.iris.irisback.service.EtapeProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/etapeProduction")
@CrossOrigin(origins = "*")
public class EtapeProductionController {

  @Autowired EtapeProductionService productionService;

  @PostMapping("/addEtapeProduction")
  public EtapeProductionDTO processEtapeProduction(
      @RequestBody final EtapeProductionDTO etapeProductionDTO) throws IOException {
    return productionService.addEtapeProduction(etapeProductionDTO);
    //     return  clientRepository.save(client);
  }

  /*


      @PostMapping("/chronoEtape")
      public  void  chnronoOf(@RequestBody OrdreFabricationDTO ordreFabricationDTO){

          LocalTime localTime = LocalTime.now();
          if(ordreFabricationDTO.getDebutHeure().getTime() == localTime.getHour()){
              while (ordreFabricationDTO.getFinHeure()!==localTime.getHour()){
  ordreFabricationDTO.
              }
          }
      }

  */

  // kol etape tekhou des articles w kol articles yet3ada b des etapes
}
