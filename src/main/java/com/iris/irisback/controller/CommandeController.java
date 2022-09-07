package com.iris.irisback.controller;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.model.Commande;
import com.iris.irisback.service.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/commande")
@CrossOrigin(origins = "*")
public class CommandeController {

  final CommandeService commandeService;

  public CommandeController(final CommandeService commandeService) {
    this.commandeService = commandeService;
  }

  @PostMapping("/addCommande")
  public CommandeDTO addCommande(
      @RequestParam final Date dateCmd,
      @RequestParam final String numCmd,
      @RequestParam final String typeCmd,
      @RequestParam final String nomClient,
      @RequestParam final List<String> articles) {

    return commandeService.addCommande(dateCmd, numCmd, typeCmd, nomClient, articles);
  }

  @GetMapping("/commandes")
  List<Commande> Commandes()   {
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
  @PutMapping("/addToCommand/{idArticle}/{idCmd}")
  public CommandeDTO addToCommand(@PathVariable(value = "idArticle") final String idArticle, @PathVariable(value = "idCmd") final String idCmd
  ) {
    return commandeService.addToCommand(idArticle,idCmd);
  }
  @DeleteMapping("/deleteCommande/{idCommande}")
  public ResponseEntity<Void> deleteCommande(
      @PathVariable(value = "idCommande") final String idCommande) throws IOException {
    commandeService.deleteCommande(idCommande);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/updateCommande/{commandeId}")
  public CommandeDTO updateCommande(
          @RequestParam final Date dateCmd,
          @RequestParam final String numCmd,
          @RequestParam final String typeCmd,
          @RequestParam final String nomClient,
          @RequestParam final List<String> articles,
      @PathVariable("commandeId") final String commandeId) {
    return commandeService.updateCommande(dateCmd, numCmd, typeCmd, nomClient, articles, commandeId);
  }
  @PutMapping("/ajouterAcmd/{idArticle}/{idCommande}")
  public CommandeDTO ajouterAcmd(
          @PathVariable("idArticle") final String idArticle,
          @PathVariable("idCommande") final String idCommande) {
    return commandeService.ajouterAcmd(idArticle, idCommande);
  }
}
