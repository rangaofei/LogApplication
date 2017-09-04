package com.sak.logutil;

import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class NoRectStrategy {
    private String message;
    private boolean outputStackInfo;
    private StringBuilder stackInfo;

    public NoRectStrategy(String message, boolean outputStackInfo) {
        this.message = message;
        this.outputStackInfo = outputStackInfo;
    }

    public void setStackInfo(StringBuilder stackInfo) {
        this.stackInfo = stackInfo;
    }

    public String printMessage() {
        if (!outputStackInfo) {
            stackInfo = new StringBuilder("");
        }
        StringBuilder result = new StringBuilder(stackInfo);
        result.append(message);
        return result.toString();
    }
}
