package com.github.mouse0w0.jytekit.util;

import java.util.List;

public class ASMUtils {

    public static String formatASMTextList(List<?> text) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : text) {
            if (obj instanceof String)
                sb.append(obj);
            else if (obj instanceof List)
                sb.append(formatASMTextList((List<?>) obj));
        }
        return sb.toString();
    }
}
