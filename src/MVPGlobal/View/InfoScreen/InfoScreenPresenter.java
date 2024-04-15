package MVPGlobal.View.InfoScreen;

import MVPGlobal.View.UISettings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.BufferedReader;
import java.io.FileReader;

public class InfoScreenPresenter {

    private InfoScreenView view;
    private UISettings uiSettings;

    public InfoScreenPresenter(InfoScreenView view, UISettings uiSettings) {
        this.view = view;
        this.uiSettings = uiSettings;
        view.getInfoText().setText(readInfoFromFile());
        view.getBtnOk().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getScene().getWindow().hide();
            }
        });
    }

    private String readInfoFromFile() {
        StringBuilder infoTextInFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(uiSettings.getInfoTextPath().toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                infoTextInFile.append(line).append("\n");
            }
        } catch (Exception ex) {
            // Do nothing if info.txt file cannot be read or is incomplete.
            // A standard text will be returned.
        }
        return infoTextInFile.length() == 0 ? "No info available" : infoTextInFile.toString();
    }
}
