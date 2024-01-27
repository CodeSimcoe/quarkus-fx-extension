# Quarkiverse extension
Extension dev has moved to : https://github.com/quarkiverse/quarkus-fx

# quarkus-fx-extension
This Quarkus extension allows you to use JavaFX in your Quarkus application. \
It will allow component injection in FX Controllers and will allow you to use CDI events to register on primary stage creation.

Live reload is still problematic and will be studied in the future.

You'll have to use a custom Main in your application
```java
package com.codesimcoe.fxapp;

import com.codesimcoe.quarkus.fx.extension.runtime.FxApplication;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import javafx.application.Application;

@QuarkusMain
public class CDIApplication implements QuarkusApplication {

  public static void main(String[] args) {
    Quarkus.run(CDIApplication.class);
  }

  @Override
  public int run(String... args) {
    Application.launch(FxApplication.class, args);
    return 0;
  }
}
```

And you will be able to register on primary stage creation event via such example code.
```java
import java.io.InputStream;

public class QuarkusFxApp {

  @Inject
  FXMLLoader fxmlLoader;

  public void start(@Observes @PrimaryStage Stage stage) {
    try {
      URL fxml = this.getClass().getResource("/app.fxml");
      Parent fxmlParent = this.fxmlLoader.load(fxml.openStream());

      Scene scene = new Scene(fxmlParent);
      stage.setScene(scene);
      stage.show();

    } catch (IOException e) {
      // TODO
    }
  }
}
```
It might be a good practice to use :
```java
@Inject
Instance<FXMLLoader> fxmlLoader;
```
And create a new instance of FXMLLoader for each .fxml file to load. \
Also, setting the location is required by some use cases (use of relative paths in FXML)

```java
// It is best to get a new instance of FXMLLoader for each page
FXMLLoader instance = this.fxmlLoader.get();

// Set location for relative path resolution
instance.setLocation(xxx);
```

Based on https://github.com/pedrolopix work and updated so far.
