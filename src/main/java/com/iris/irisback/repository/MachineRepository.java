package com.iris.irisback.repository;

import com.iris.irisback.model.Machine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends MongoRepository<Machine, String> {
  Machine findMachineById(String idMachine);

  Machine findMachineByDesignation(String designation);

  // List<Machine> findAll();
}
