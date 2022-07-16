package com.iris.irisback.controller;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/commande")
@CrossOrigin(origins = "*")
public class CommandeController {

  @Autowired CommandeService commandeService;

  @PostMapping("/addCommande")
  public CommandeDTO addCommande(@RequestBody final CommandeDTO commandeDTO) throws IOException {
    return commandeService.addCommande(commandeDTO);
  }

  @GetMapping("/commandes")
  List<CommandeDTO> Commandes() throws IOException {
    return commandeService.Commandes();
  }

  @GetMapping("/{clientId}/myCommandes")
  List<CommandeDTO> myCommandes(@PathVariable(value = "clientId") final String clientId)
      throws IOException {
    return commandeService.myCommandes(clientId);
  }

  @GetMapping("/{idCmd}")
  CommandeDTO getCmdById(@PathVariable(value = "idCmd") final String idCmd) throws IOException {
    return commandeService.getCmdById(idCmd);
  }

  @DeleteMapping("/deleteCommande/{idCommande}")
  public ResponseEntity<Void> deleteCommande(
      @PathVariable(value = "idCommande") final String idCommande) throws IOException {
    commandeService.deleteCommande(idCommande);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/updateCommande/{commandeId}")
  public CommandeDTO updateCommande(
      @RequestBody final CommandeDTO commandeDTO,
      @PathVariable("commandeId") final String commandeId) {
    return commandeService.updateCommande(commandeDTO, commandeId);
  }
}
