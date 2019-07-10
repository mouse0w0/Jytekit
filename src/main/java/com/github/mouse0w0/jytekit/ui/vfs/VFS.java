package com.github.mouse0w0.jytekit.ui.vfs;

import com.github.mouse0w0.jytekit.ui.ClassEditUI;
import com.github.mouse0w0.jytekit.ui.UIBootstrap;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseButton;

import java.nio.file.Path;

public class VFS {

    public static void createVFSFromClass(TreeView<VFSEntry> treeView, Path classFile) {
        treeView.setCellFactory($ -> new VFSTreeCell());

        TreeItem<VFSEntry> root = new TreeItem<>();
        treeView.setRoot(root);
        treeView.setShowRoot(false);

        String fileName = classFile.getFileName().toString();
        String className = fileName.substring(0, fileName.indexOf('.'));
        TreeItem<VFSEntry> classItem = new TreeItem<>(new ClassEntry(className, classFile));
        root.getChildren().add(classItem);
    }

    public static void createVFSFromJar(TreeView<VFSEntry> treeView, Path jarFile) {

    }

    private static class VFSTreeCell extends TreeCell<VFSEntry> {

        @Override
        protected void updateItem(VFSEntry item, boolean empty) {
            if (empty || item == null) {
                setText(null);
                setGraphic(null);
                setOnMouseClicked(null);
            } else {
                setText(item.getName());
                setGraphic(getTreeItem().getGraphic());
                if (item instanceof ClassEntry) {
                    setOnMouseClicked(event -> {
                        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                            UIBootstrap.getMainUI().showClassEditUI(new ClassEditUI((ClassEntry) item));
                        }
                    });
                }
            }
        }
    }

}
