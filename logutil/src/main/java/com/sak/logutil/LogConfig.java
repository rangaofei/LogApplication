package com.sak.logutil;

import com.saka.logutil.BuildConfig;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class LogConfig {
    private String TAG = "saka";
    private boolean isDebug = BuildConfig.DEBUG;
    private boolean outputStackInfo = true;
    private boolean outputRect = false;

    private LogConfig(Builder builder) {
        isDebug = builder.isDebug;
        outputStackInfo = builder.outputStackInfo;
        outputRect = builder.outputRect;
    }

    public String getTAG() {
        return TAG;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public boolean isOutputStackInfo() {
        return outputStackInfo;
    }

    public boolean isOutputRect() {
        return outputRect;
    }

    public static final class Builder {
        private boolean isDebug;
        private boolean outputStackInfo;
        private boolean outputRect;

        public Builder() {
        }

        public Builder isDebug(boolean val) {
            isDebug = val;
            return this;
        }

        public Builder outputStackInfo(boolean val) {
            outputStackInfo = val;
            return this;
        }

        public Builder outputRect(boolean val) {
            outputRect = val;
            return this;
        }

        public LogConfig build() {
            return new LogConfig(this);
        }
    }
}
