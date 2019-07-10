package com.github.mouse0w0.jytekit.ui;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class TextAreaDialog extends Stage {

    private final TextArea textArea;

    public TextAreaDialog() {
        textArea = new TextArea();
        textArea.setPrefSize(800, 600);
        Scene scene = new Scene(textArea);
        setScene(scene);
    }

    public TextArea getTextArea() {
        return textArea;
    }
}
