package com.codesimcoe.quarkus.fx.extension.deployment;

import com.codesimcoe.quarkus.fx.extension.runtime.FXMLLoaderProducer;
import com.codesimcoe.quarkus.fx.extension.runtime.PrimaryStage;
import com.codesimcoe.quarkus.fx.extension.runtime.QuarkusFxLaunchRecorder;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.FeatureBuildItem;

import static io.quarkus.deployment.annotations.ExecutionTime.RUNTIME_INIT;

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

  @Record(RUNTIME_INIT)
  @BuildStep
  public void launch(final QuarkusFxLaunchRecorder recorder) {
    recorder.launchFxApplication();
  }
}
