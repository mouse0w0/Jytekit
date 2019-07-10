package com.github.mouse0w0.jytekit.ui.vfs;

import java.nio.file.Path;

public class SimpleVFSEntry implements VFSEntry {

    private final String name;
    private final Path path;

    public SimpleVFSEntry(String name, Path path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Path getPath() {
        return path;
    }
}
