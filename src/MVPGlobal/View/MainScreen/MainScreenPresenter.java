package MVPGlobal.View.MainScreen;

import MVPGlobal.View.AboutScreen.*;
import MVPGlobal.View.InfoScreen.*;
import MVPGlobal.View.SettingsScreen.*;
import MVPGlobal.View.UISettings;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.List;

public class MainScreenPresenter {

    private MainScreenView view;
    private UISettings uiSettings;

    public MainScreenPresenter(MainScreenView view, UISettings uiSettings) {
        this.view = view;
        this.uiSettings = uiSettings;
        updateView();
        eventHandlers();
    }

    private void updateView() {
        // Voer eventuele updates van de weergave uit
    }

    private void eventHandlers() {
        view.getSettingsItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openSettings();
            }
        });
        view.getLoadItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadData();
            }
        });
        view.getSaveItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveData();
            }
        });
        view.getExitItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleCloseEvent(event);
            }
        });
        view.getAboutItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openAbout();
            }
        });
        view.getInfoItem().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openInfo();
            }
        });
    }

    public void windowsHandler() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                handleCloseEvent(event);
            }
        });
    }

    private void openSettings() {
        SettingsView settingsView = new SettingsView(uiSettings);
        SettingsPresenter presenter = new SettingsPresenter(settingsView, uiSettings);
        Stage settingsStage = createStage(settingsView, "Settings", "Settings");
        settingsStage.showAndWait();
    }

    private void loadData() {
        // Implementeer de logica voor het laden van gegevens
    }

    private void saveData() {
        // Implementeer de logica voor het opslaan van gegevens
    }

    private void handleCloseEvent(Event event) {
        // Implementeer logica voor het afsluiten van het venster
    }

    private void openAbout() {
        AboutScreenView aboutScreenView = new AboutScreenView(uiSettings);
        AboutScreenPresenter aboutScreenPresenter = new AboutScreenPresenter(aboutScreenView, uiSettings);
        Stage aboutScreenStage = createStage(aboutScreenView, "About", "About");
        aboutScreenStage.showAndWait();
    }

    private void openInfo() {
        InfoScreenView infoScreenView = new InfoScreenView(uiSettings);
        InfoScreenPresenter infoScreenPresenter = new InfoScreenPresenter(infoScreenView, uiSettings);
        Stage infoScreenStage = createStage(infoScreenView, "Info", "Info");
        infoScreenStage.showAndWait();
    }

    private Stage createStage(Parent view, String title, String windowTitle) {
        Stage stage = new Stage();
        stage.initOwner(view.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(view));
        stage.setTitle(uiSettings.getApplicationName() + " - " + windowTitle);
        stage.setX(view.getScene().getWindow().getX() + uiSettings.getResX() / 10);
        stage.setY(view.getScene().getWindow().getY() + uiSettings.getResY() / 10);
        if (Files.exists(uiSettings.getApplicationIconPath())) {
            try {
                stage.getIcons().add(new Image(uiSettings.getApplicationIconPath().toUri().toURL().toString()));
            } catch (MalformedURLException ex) {
                // Do nothing, if toURL-conversion fails, program can continue
            }
        }
        return stage;
    }
}
