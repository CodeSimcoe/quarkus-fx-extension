package com.codesimcoe.quarkus.fx.extension.runtime;

import io.quarkus.runtime.annotations.Recorder;
import javafx.application.Application;

@Recorder
public class QuarkusFxLaunchRecorder {

  public void launchFxApplication() {
    // TODO : get args from somewhere
    Application.launch(FxApplication.class/*, args*/);
  }
}
