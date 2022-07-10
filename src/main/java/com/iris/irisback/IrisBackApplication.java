package com.iris.irisback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class IrisBackApplication {

  public static void main(final String[] args) throws IOException {
    SpringApplication.run(IrisBackApplication.class, args);
  }
  //
  //  final String Host = "localhost";
  //  final String Port = "27017";
  //  final String DB = "irisDB";
  //  final String CollectionName = "machine";
  //  final String FileName = "/static/Machine.csv";
  //
  //  @Override
  //  public void run(final String... args) throws Exception {
  //    final String command =
  //        "C:\\Programmes\\MongoDB\\Server\\5.0\\bin\\mongoimport.exe --host "
  //            + Host
  //            + " --port "
  //            + Port
  //            + " --db "
  //            + DB
  //            + " --collection "
  //            + CollectionName
  //            + "--authenticationDatabase admin --username "
  //            + " --headerline  --type=csv  --file "
  //            + FileName;
  //
  //    try {
  //      final Process process = Runtime.getRuntime().exec(command);
  //      System.out.println("Imported csv into Database");
  //    } catch (final Exception e) {
  //      System.out.println("Error executing " + command + e.toString());
  //    }
  //  }
}
