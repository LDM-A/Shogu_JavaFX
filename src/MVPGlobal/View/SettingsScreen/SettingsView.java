package MVPGlobal.View.SettingsScreen;

import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SettingsView extends BorderPane {

    private UISettings uiSettings;
    private MenuItem exitMenuItem;
    private TextField cssNameField;
    private Button cssSelectButton;
    private Button okButton;

    public SettingsView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.exitMenuItem = new MenuItem("Exit");
        this.cssSelectButton = new Button("Select File");
        this.cssNameField = new TextField();
        this.cssNameField.setPrefWidth(uiSettings.getLowestRes() / 3);
        this.cssNameField.setText(uiSettings.getStyleSheetPath().toString());
        this.okButton = new Button("OK");
    }

    private void layoutNodes() {
        Menu menuFile = new Menu("File");
        menuFile.getItems().addAll(exitMenuItem);
        MenuBar menuBar = new MenuBar(menuFile);
        setTop(menuBar);

        HBox cssSettings = new HBox();
        cssSettings.setSpacing(uiSettings.getLowestRes() / 100);
        cssSettings.setPadding(new Insets(20));
        Label cssLabel = new Label("Style Sheet File Name:");
        cssSettings.getChildren().addAll(cssLabel, cssNameField, cssSelectButton);
        setCenter(cssSettings);

        BorderPane.setAlignment(okButton, Pos.BOTTOM_RIGHT);
        BorderPane.setMargin(okButton, new Insets(10));
        setBottom(okButton);
    }

    MenuItem getExitItem() {
        return exitMenuItem;
    }

    Button getCssButton() {
        return cssSelectButton;
    }

    TextField getCssName() {
        return cssNameField;
    }

    Button getOkButton() {
        return okButton;
    }
}
