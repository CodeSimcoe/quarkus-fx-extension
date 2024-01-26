# quarkus-fx-extension
This Quarkus extension allows you to use JavaFX in your Quarkus application. \
It will allow component injection in FX Controllers and will allow you to use CDI events to register on primary stage creation.

Live reload is still problematic and will be studied in the future.

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
