package com.codesimcoe.quarkus.fx.extension.runtime;

import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import javafx.fxml.FXMLLoader;

public class FXMLLoaderProducer {

  @Inject
  Instance<Object> instance;

  @Produces
  FXMLLoader produceFXMLLoader() {
    FXMLLoader loader = new FXMLLoader();
    loader.setControllerFactory(param -> {
      System.out.println("param = " + param);
      return this.instance.select(param).get();
    });

    return loader;
  }
}
