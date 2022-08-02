package com.iris.irisback.repository;

import com.iris.irisback.model.OrdreFabrication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdreFabricationRepository extends MongoRepository<OrdreFabrication, String> {}
