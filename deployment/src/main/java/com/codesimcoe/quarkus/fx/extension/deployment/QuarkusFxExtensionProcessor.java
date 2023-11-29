package com.codesimcoe.quarkus.fx.extension.deployment;

import com.codesimcoe.quarkus.fx.extension.runtime.FXMLLoaderProducer;
import com.codesimcoe.quarkus.fx.extension.runtime.PrimaryStage;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.arc.deployment.QualifierRegistrarBuildItem;
import io.quarkus.arc.processor.QualifierRegistrar;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.builditem.LiveReloadBuildItem;
import org.jboss.jandex.DotName;

import java.util.Map;
import java.util.Set;

class QuarkusFxExtensionProcessor {

  private static final String FEATURE = "quarkus-fx-extension";

  @BuildStep
  FeatureBuildItem feature() {
    return new FeatureBuildItem(FEATURE);
  }

  @BuildStep
  AdditionalBeanBuildItem fxmlLoader() {
    return new AdditionalBeanBuildItem(FXMLLoaderProducer.class);
  }

  @BuildStep
  AdditionalBeanBuildItem primaryStage() {
    return new AdditionalBeanBuildItem(PrimaryStage.class);
  }
}
