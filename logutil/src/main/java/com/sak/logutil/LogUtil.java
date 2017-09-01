package com.sak.logutil;


public class LogUtil {
    private static String TAG = "saka";
    private static boolean isDebug = BuildConfig.DEBUG;
    private static boolean outputStackInfo = true;
    private static boolean outputRect = false;

    public LogUtil(String TAG, boolean isDebug) {
        LogUtil.TAG = TAG;
        LogUtil.isDebug = isDebug;
    }

    public static void setOutputRect(boolean outputRect) {
        LogUtil.outputRect = outputRect;
    }

    public static void setOutputStackInfo(boolean outputStackInfo) {
        LogUtil.outputStackInfo = outputStackInfo;
    }

    public static LogUtil init(String TAG, boolean isDebug) {
        return new LogUtil(TAG, isDebug);
    }/*
     * Send a VERBOSE log message.
     *
     * @param msg The message you would like logged.
     */

    public static void v(String msg) {
        if (isDebug)
            android.util.Log.v(TAG, buildMessage(msg));
    }

    /**
     * Send a VERBOSE log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void v(String msg, Throwable thr) {
        if (isDebug)
            android.util.Log.v(TAG, buildMessage(msg), thr);
    }

    /**
     * Send a DEBUG log message.
     *
     * @param msg
     */
    public static void d(String msg) {
        if (isDebug)
            android.util.Log.d(TAG, buildMessage(msg));
    }

    /**
     * Send a DEBUG log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void d(String msg, Throwable thr) {
        if (isDebug)
            android.util.Log.d(TAG, buildMessage(msg), thr);
    }

    /**
     * Send an INFO log message.
     *
     * @param msg The message you would like logged.
     */
    public static void i(String msg) {
        if (isDebug)
            android.util.Log.i(TAG, buildMessage(msg));
    }

    /**
     * Send a INFO log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void i(String msg, Throwable thr) {
        if (isDebug)
            android.util.Log.i(TAG, buildMessage(msg), thr);
    }

    /**
     * Send an ERROR log message.
     *
     * @param msg The message you would like logged.
     */
    public static void e(String msg) {
        if (isDebug)
            android.util.Log.e(TAG, buildMessage(msg));
    }

    /**
     * Send a WARN log message
     *
     * @param msg The message you would like logged.
     */
    public static void w(String msg) {
        if (isDebug)
            android.util.Log.w(TAG, buildMessage(msg));
    }

    /**
     * Send a WARN log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void w(String msg, Throwable thr) {
        if (isDebug)
            android.util.Log.w(TAG, buildMessage(msg), thr);
    }

    /**
     * Send an empty WARN log message and log the exception.
     *
     * @param thr An exception to log
     */
    public static void w(Throwable thr) {
        if (isDebug)
            android.util.Log.w(TAG, buildMessage(""), thr);
    }

    /**
     * Send an ERROR log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void e(String msg, Throwable thr) {
        if (isDebug)
            android.util.Log.e(TAG, buildMessage(msg), thr);
    }

    /**
     * Building Message
     *
     * @param msg The message you would like logged.
     * @return Message String
     */
    protected static String buildMessage(String msg) {
        if (!outputStackInfo) {
            return msg;
        }
        StackTraceElement caller = new Throwable().fillInStackTrace().getStackTrace()[2];
        StringBuilder stackInfo = new StringBuilder().append(caller.getClassName()).append(".").append(caller.getMethodName()).append("(): ");
        if (!outputRect) {
            return stackInfo.append(msg).toString();
        } else {
            StringBuilder result = new StringBuilder(stackInfo);
            addHeader(result, msg.length());
            addPreChar(result, stackInfo.length());
            result.append(msg);
            addAfterChar(result);
            addFooter(result, msg.length(), stackInfo.length());
            return result.toString();
        }
    }

    private static void addHeader(StringBuilder result, int length) {
        result.append('+');
        for (int i = 0; i < length + 4; i++) {
            result.append('-');
        }
        result.append('+');
        result.append("\n");
    }

    private static void addPreChar(StringBuilder result, int length) {
        for (int i = 0; i < length; i++) {
            result.append(" ");
        }
        result.append("|  ");
    }

    private static void addAfterChar(StringBuilder result) {
        result.append("  |\n");
    }

    private static void addFooter(StringBuilder result, int length, int l) {
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
