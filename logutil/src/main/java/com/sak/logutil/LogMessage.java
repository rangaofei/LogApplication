package com.sak.logutil;

import java.nio.charset.Charset;

/**
 * Created by saka on 2017/9/4.
 */

public class LogMessage {
    private String stackInfo;
    private int maxLength;
    private int stackInfoLength;
    private int msgLength;
    private String msg;

    public LogMessage(String stackInfo, String msg) {
        this.stackInfo = stackInfo;
        this.msg = msg;
        stackInfoLength = stackInfo.getBytes(Charset.forName("gbk")).length;
        msgLength = msg.getBytes(Charset.forName("gbk")).length;
        maxLength = Math.max(stackInfoLength, msgLength) + 2;
    }

    public String getStackInfo() {
        return stackInfo;
    }

    public String getMsg() {
        return msg;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public String getWrapStackInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        for (int i = 0; i < maxLength; i++) {
            sb.append('-');
        }
        sb.append("+\n");
        sb.append('|');
        sb.append(" ");
        sb.append(stackInfo);
        for (int i = 0; i < maxLength - stackInfoLength - 1; i++) {
            sb.append(" ");
        }
        sb.append("|\n");
        return sb.toString();
    }

    public String getWrapMsg() {
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        for (int i = 0; i < maxLength; i++) {
            sb.append('-');
        }
        sb.append("+\n");
        sb.append('|');
        sb.append(" ");
        sb.append(msg);
        for (int i = 0; i < maxLength - msgLength - 1; i++) {
            sb.append(" ");
        }
        sb.append("|\n");
        sb.append('+');
        for (int i = 0; i < maxLength; i++) {
            sb.append('-');
        }
        sb.append('+');
        return sb.toString();
    }
}
