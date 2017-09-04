package com.sak.logutil;

import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class OutputRectStrategy {
    private String message;
    private boolean outputStackInfo;
    private int preLength;

    private StringBuilder stackInfo;

    public OutputRectStrategy(String message, boolean outputStackInfo) {
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
        if (stackInfo != null) {
            preLength = stackInfo.length();
        }
        StringBuilder result = new StringBuilder(stackInfo);
        addHeader(result, message.getBytes(Charset.forName("gbk")).length);
        addPreChar(result, preLength);
        result.append(message);
        addAfterChar(result);
        addFooter(result, message.getBytes(Charset.forName("gbk")).length, preLength);
        return result.toString();
    }

    private void addHeader(StringBuilder result, int length) {
        result.append('+');
        for (int i = 0; i < length + 4; i++) {
            result.append('-');
        }
        result.append('+');
        result.append("\n");
    }

    private void addPreChar(StringBuilder result, int length) {
        for (int i = 0; i < length; i++) {
            result.append(" ");
        }
        result.append("|  ");
    }

    private void addAfterChar(StringBuilder result) {
        result.append("  |\n");
    }

    private void addFooter(StringBuilder result, int length, int l) {
        for (int i = 0; i < l; i++) {
            result.append(" ");
        }
        result.append('+');
        for (int i = 0; i < length + 4; i++) {
            result.append('-');
        }
        result.append('+');
    }
}
