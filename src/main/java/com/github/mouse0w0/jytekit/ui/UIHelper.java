package com.github.mouse0w0.jytekit.ui;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class UIHelper {

    public static void load(Object root, String name) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setController(root);
            loader.setRoot(root);
            loader.setCharset(StandardCharsets.UTF_8);
            loader.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("ui/" + name + ".fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void load(Object root, URL url) {
        try {
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(root);
            loader.setRoot(root);
            loader.setCharset(StandardCharsets.UTF_8);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
