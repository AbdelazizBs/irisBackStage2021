package com.iris.irisback.controller;

import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.service.ClientService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {
  final ClientService clientService;

  public ClientController(final ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping("/addClient")
  public ClientDTO addClient(
      @RequestBody final ClientDTO clientDTO, final BindingResult bindingResult)
      throws IOException {
    return clientService.addClient(clientDTO, bindingResult);
    //     return  clientRepository.save(client);
  }

  @PutMapping("/updateClient/{idClient}")
  public ClientDTO updateClient(
      @RequestBody final ClientDTO clientDTO,
      @PathVariable(value = "idClient") final String idClient)
      throws IOException {
    return clientService.updateClient(clientDTO, idClient);
  }

  @PostMapping("/login")
  public ClientDTO login(
      @Valid @RequestParam(value = "email") final String email,
      @RequestParam(value = "password") final String password)
      throws IOException {
    return clientService.login(email, password);
  }

  @GetMapping("/getClientById/{idClient}")
  public ClientDTO getClientbyid(@PathVariable(value = "idClient") final String idClient)
      throws IOException {
    return clientService.getClientById(idClient);
  }

  @GetMapping("/getClientByEmail")
  public ClientDTO getClientByEmail(@Valid @RequestParam(value = "email") final String email)
      throws IOException {
    return clientService.getClientByEmail(email);
  }

  @PutMapping("/desactivateClient/{idClient}")
  public ClientDTO desactivateClient(@PathVariable(value = "idClient") final String idClient) {
    return clientService.desactivateClient(idClient);
  }

  @PutMapping("/activateClient/{idClient}")
  public ClientDTO activateClient(@PathVariable(value = "idClient") final String idClient) {
    return clientService.activateClient(idClient);
  }

  @GetMapping("/getNomClients")
  public List<String> getNomClients() throws IOException {
    return clientService.getNomClients();
  }
}
