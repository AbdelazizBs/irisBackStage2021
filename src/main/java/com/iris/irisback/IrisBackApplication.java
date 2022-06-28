package com.iris.irisback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IrisBackApplication {

  public static void main(final String[] args) {
    SpringApplication.run(IrisBackApplication.class, args);
  }
  /*
  @Override
  public void run() {
    final Date date = new Date(2014, 6, 20, 0, 0);
    final Machine machine =
        new Machine(
            "2211",
            "defaultNom",
            "default",
            "libellesa",
            new EtapeProduction("1122", "aaaaachch", "typeEtape"),
            "2",
            date);
    machineRepository.save(machine);
  }*/
}
