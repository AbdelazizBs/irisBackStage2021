package com.iris.irisback.service;

import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.ClientMapper;
import com.iris.irisback.model.Client;
import com.iris.irisback.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
  final ClientRepository clientRepository;

  public ClientService(final ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

//  public ClientDTO login(final String email, final String password) throws IOException {
//    return ClientMapper.MAPPER.toClientDTO(
//        clientRepository.findClientByEmailAndPassword(email, password));
//  }

  public ClientDTO getClientById(final String idClient)   {
    return ClientMapper.MAPPER.toClientDTO(clientRepository.findClientById(idClient));
  }

  public ClientDTO getClientByEmail(final String email)   {
    return ClientMapper.MAPPER.toClientDTO(clientRepository.findClientByEmail(email));
  }

    public List<ClientDTO> getListClient()   {
        return clientRepository.findAll().stream()
                .map(client -> ClientMapper.MAPPER.toClientDTO(client))
                .collect(Collectors.toList());
    }

    public void deleteClient(final String idClient) {
        clientRepository.deleteById(idClient);
    }


    public ClientDTO addClient(         final String nom,
                                       final String company,
                                       final String address,
                                       final String phone,
                                       final String country,
                                       final String reference,
                                       final String email)
        {
    final Client clientExist = clientRepository.findClientByEmail(email);
//    if (clientExist != null) {
//      bindingResult.rejectValue(
//          "email", "error.user", "There is already a user registered with the email provided");
//    }
    final ClientDTO clientDTO = new ClientDTO();
    clientDTO.setNom(nom);
    clientDTO.setEmail(email);
    clientDTO.setCountry(country);
    clientDTO.setCompany(company);
    clientDTO.setAddress(address);
    clientDTO.setPhone(phone);
    clientDTO.setReference(reference);
    final Client client = ClientMapper.MAPPER.toClient(clientDTO);
    client.setActive(false);
    // client.setPassword(bCryptPasswordEncoder.encode(clientDTO.getPassword()));
    return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
  }

  public ClientDTO updateClient(      final String nom,
                                      final String company,
                                      final String address,
                                      final String phone,
                                      final String country,
                                      final String email,
                                      final String reference,
                                      final String idClient)
        {
    return clientRepository
        .findById(idClient)
        .map(
            client -> {
              client.setAddress(address);
              client.setCompany(company);
              client.setCountry(country);
              client.setEmail(email);
              client.setNom(nom);
              client.setReference(reference);
//              client.setPassword(clientDTO.getPassword());
              client.setPhone(phone);
              return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
            })
        .orElseThrow(() -> new NotFoundException(nom + " not found"));
  }

  public ClientDTO desactivateClient(final String idClient) {
    return clientRepository
        .findById(idClient)
        .map(
            client -> {
              client.setActive(false);
              return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
            })
        .orElseThrow(() -> new NotFoundException(idClient + " not found"));
  }

  public ClientDTO activateClient(final String idClient) {
    return clientRepository
        .findById(idClient)
        .map(
            client -> {
              client.setActive(true);
              return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
            })
        .orElseThrow(() -> new NotFoundException(idClient + " not found"));
  }

  public List<String> getNomClients()   {
    return clientRepository.findAll().stream().map(Client::getNom).collect(Collectors.toList());
  }
}
