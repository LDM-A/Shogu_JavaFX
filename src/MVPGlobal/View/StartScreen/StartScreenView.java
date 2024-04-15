package MVPGlobal.View.StartScreen;

import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.MalformedURLException;
import java.nio.file.Files;

public class StartScreenView extends BorderPane {

    private UISettings uiSettings;
    private Label timeDisplay;
    private ProgressBar timeProgress;
    private StartScreenTransition trans;

    public StartScreenView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
        animate();
    }

    private void initialiseNodes() {
        this.timeDisplay = new Label("Loading: 0.0");
        this.timeProgress = new ProgressBar();
    }

    private void layoutNodes() {
        int imageSize = uiSettings.getLowestRes() / 5;
        BorderPane progressPane = new BorderPane();
        progressPane.setRight(this.timeProgress);
        progressPane.setLeft(this.timeDisplay);
        BorderPane.setMargin(this.timeDisplay, new Insets(uiSettings.getInsetsMargin()));
        BorderPane.setMargin(this.timeProgress, new Insets(uiSettings.getInsetsMargin()));
        ImageView centralImage;
        if (Files.exists(uiSettings.getStartScreenImagePath())) {
            try {
                centralImage = new ImageView(new Image(uiSettings.getStartScreenImagePath().toUri().toURL().toString()));
                centralImage.setPreserveRatio(true);
                centralImage.setFitHeight(imageSize);
                centralImage.setFitWidth(imageSize);
                centralImage.setSmooth(true);
                this.setCenter(centralImage);
            } catch (MalformedURLException ex) {
                ex.printStackTrace(); // Voeg foutafhandeling toe om de fout te tonen
            }
        } else {
            // Doe niets als StartScreenImage niet beschikbaar is
        }
        this.setBottom(progressPane);
    }

    Label getTimeDisplay() {
        return timeDisplay;
    }

    ProgressBar getTimeProgress() {
        return timeProgress;
    }

    StartScreenTransition getTransition() {
        return trans;
    }

    private void animate() {
        trans = new StartScreenTransition(this, 3);
        trans.play();
    }
}
