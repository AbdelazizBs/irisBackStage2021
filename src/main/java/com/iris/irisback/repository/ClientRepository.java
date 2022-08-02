package com.iris.irisback.repository;

import com.iris.irisback.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
  //   Commande findCommandeByClientId(String clientId) ;
  Client findClientById(String id);

  Client findClientByNom(String nom);

  Client findClientByEmail(String s);

//  Client findClientByEmailAndPassword(String email, String password);
}
