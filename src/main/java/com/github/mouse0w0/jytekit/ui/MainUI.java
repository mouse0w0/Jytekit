package com.github.mouse0w0.jytekit.ui;

import com.github.mouse0w0.jytekit.ui.vfs.VFS;
import com.github.mouse0w0.jytekit.ui.vfs.VFSEntry;
import javafx.fxml.FXML;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;

public class MainUI extends BorderPane {

    @FXML
    public TreeView<VFSEntry> treeView;

    @FXML
    public AnchorPane container;

    public MainUI() {
        UIHelper.load(this, "Main");
    }

    @FXML
    public void openClassFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Class File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Class File", "*.class"));
        File file = fileChooser.showOpenDialog(getScene().getWindow());
        if (file != null) {
            VFS.createVFSFromClass(treeView, file.toPath());
        }
    }

    @FXML
    public void openJarFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Jar File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Jar File", "*.jar"));
        File file = fileChooser.showOpenDialog(getScene().getWindow());
        if (file != null) {
            VFS.createVFSFromJar(treeView, file.toPath());
        }
    }

    public void showClassEditUI(ClassEditUI classEditUI) {
        container.getChildren().setAll(classEditUI);
        AnchorPane.setTopAnchor(classEditUI, 0D);
        AnchorPane.setRightAnchor(classEditUI, 0D);
        AnchorPane.setBottomAnchor(classEditUI, 0D);
        AnchorPane.setLeftAnchor(classEditUI, 0D);
    }
}
