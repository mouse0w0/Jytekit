package com.github.mouse0w0.jytekit.ui.vfs;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClassEntry extends SimpleVFSEntry {

    private SoftReference<ClassNode> cachedClassNode;

    public ClassEntry(String name, Path path) {
        super(name, path);
    }

    public ClassNode getClassNode() {
        ClassNode classNode = cachedClassNode == null ? loadClassNode() : cachedClassNode.get();
        return classNode == null ? loadClassNode() : classNode;
    }

    private ClassNode loadClassNode() {
        try (var input = Files.newInputStream(getPath())) {
            ClassReader cr = new ClassReader(input);
            ClassNode cn = new ClassNode();
            cachedClassNode = new SoftReference<>(cn);
            cr.accept(cn, 0);
            return cn;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
