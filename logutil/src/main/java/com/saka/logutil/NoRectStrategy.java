package com.saka.logutil;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class NoRectStrategy implements OutPutMessage {
    private LogMessage logMessage;

    public NoRectStrategy(LogMessage logMessage) {
        this.logMessage = logMessage;
    }

    @Override
    public String stackInfo() {
        if (logMessage == null) {
            return null;
        }
        return logMessage.getStackInfo();
    }

    @Override
    public String outputMessage() {
        if (logMessage == null) {
            return null;
        }
        return logMessage.getMsg();
    }
}
