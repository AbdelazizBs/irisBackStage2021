package com.iris.irisback.repository;

import com.iris.irisback.model.OrdreFabrication;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdreFabricationRepository extends MongoRepository<OrdreFabrication,String> {
}
