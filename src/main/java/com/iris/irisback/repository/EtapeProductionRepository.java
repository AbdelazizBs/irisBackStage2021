package com.iris.irisback.repository;

import com.iris.irisback.model.EtapeProduction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapeProductionRepository extends MongoRepository<EtapeProduction,String> {
    EtapeProduction findEtapeProductionByNomEtape(String s);
}
