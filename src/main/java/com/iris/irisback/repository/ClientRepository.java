package com.iris.irisback.repository;

import com.iris.irisback.model.Client;
import com.iris.irisback.model.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository  extends MongoRepository<Client,String> {
 //   Commande findCommandeByClientId(String clientId) ;
    Client findClientById(String id);
}
