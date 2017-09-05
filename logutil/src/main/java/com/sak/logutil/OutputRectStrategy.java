package com.sak.logutil;

import java.nio.charset.Charset;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class OutputRectStrategy implements OutPutMessage {
    private LogMessage logMessage;

    public OutputRectStrategy(LogMessage logMessage) {
        this.logMessage = logMessage;
    }

    @Override
    public String stackInfo() {
        if (logMessage == null) {
            return null;
        }
        return logMessage.getWrapStackInfo();
    }

    @Override
    public String outputMessage() {
        if (logMessage == null) {
            return null;
        }
        return logMessage.getWrapMsg();
    }
}
