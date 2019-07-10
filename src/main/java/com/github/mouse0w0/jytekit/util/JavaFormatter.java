package com.github.mouse0w0.jytekit.util;

import com.google.googlejavaformat.java.Formatter;

public class JavaFormatter {

    private static final Formatter FORMATTER = new Formatter();

    public static Formatter formatter() {
        return FORMATTER;
    }
}
