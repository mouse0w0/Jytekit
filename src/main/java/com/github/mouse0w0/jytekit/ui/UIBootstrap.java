package com.github.mouse0w0.jytekit.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIBootstrap extends Application {

    private static Stage primaryStage;

    private static MainUI mainUI;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static MainUI getMainUI() {
        return mainUI;
    }

    @Override
    public void start(Stage primaryStage) {
        UIBootstrap.primaryStage = primaryStage;
        mainUI = new MainUI();
        primaryStage.setScene(new Scene(mainUI));
        primaryStage.setTitle("Jytekit");
        primaryStage.show();
    }
}
