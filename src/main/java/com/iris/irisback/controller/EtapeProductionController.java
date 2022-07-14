package com.iris.irisback.controller;

import com.iris.irisback.dto.EtapeProductionDTO;
import com.iris.irisback.service.EtapeProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/etapeProduction")
@CrossOrigin(origins = "*")
public class EtapeProductionController {

  @Autowired EtapeProductionService productionService;

  @GetMapping("/getNomEtapes")
  public List<String> getNomEtapes() throws IOException {
    return productionService.getNomEtapes();
  }

  @PostMapping("/processEtapeProduction")
  public EtapeProductionDTO processEtapeProduction(
      @RequestParam final String nomEtape, @RequestParam final String typeEtape)
      throws IOException {
    return productionService.processEtapeProduction(nomEtape, typeEtape);
    //     return  clientRepository.save(client);
  }

  @GetMapping("/getEtapeById/{idEtape}")
  public EtapeProductionDTO getEtapeById(@PathVariable(value = "idEtape") final String idEtape)
      throws IOException {
    return productionService.getEtapeById(idEtape);
  }

  @GetMapping("/etapes")
  List<EtapeProductionDTO> etapes() throws IOException {
    return productionService.etapes();
  }

  @PutMapping("/updateEtape/{idEtape}")
  public EtapeProductionDTO updateEtape(
      @RequestParam final String nomEtape,
      @RequestParam final String typeEtape,
      @PathVariable(value = "idEtape") final String idEtape)
      throws IOException {
    return productionService.updateEtape(nomEtape, typeEtape, idEtape);
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
