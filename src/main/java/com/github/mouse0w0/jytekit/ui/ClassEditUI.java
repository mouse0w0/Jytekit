package com.github.mouse0w0.jytekit.ui;

import com.github.mouse0w0.jytekit.ui.vfs.ClassEntry;
import com.google.googlejavaformat.java.FormatterException;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceClassVisitor;

import static com.github.mouse0w0.jytekit.util.ASMUtils.formatASMTextList;
import static com.github.mouse0w0.jytekit.util.JavaFormatter.formatter;

public class ClassEditUI extends VBox {

    private final ClassEntry entry;

    public ClassEditUI(ClassEntry entry) {
        UIHelper.load(this, "ClassEdit");
        this.entry = entry;
    }

    @FXML
    public void openBytecodeViewer() {
        TextAreaDialog dialog = new TextAreaDialog();
        dialog.setTitle("Bytecode");
        TraceClassVisitor cv = new TraceClassVisitor(null, new Textifier(), null);
        entry.getClassNode().accept(cv);
        dialog.getTextArea().setText(formatASMTextList(cv.p.text));
        dialog.showAndWait();
    }

    @FXML
    public void openASMCode() {
        TextAreaDialog dialog = new TextAreaDialog();
        dialog.setTitle("ASMCode");
        TraceClassVisitor cv = new TraceClassVisitor(null, new ASMifier(), null);
        entry.getClassNode().accept(cv);
        try {
            dialog.getTextArea().setText(formatter().formatSource(formatASMTextList(cv.p.text)));
        } catch (FormatterException ignored) {
        }
        dialog.showAndWait();
    }
}
