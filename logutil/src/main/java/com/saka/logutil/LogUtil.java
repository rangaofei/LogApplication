package com.saka.logutil;


public class LogUtil {

    private static String TAG = "saka";
    private static boolean isDebug = BuildConfig.DEBUG;
    private static boolean outputStackInfo = true;
    private static boolean outputRect = false;
    private OutPutMessage outPutMessage;


    public static void init(LogConfig logConfig) {
        TAG = logConfig.getTAG();
        isDebug = logConfig.isDebug();
        outputStackInfo = logConfig.isOutputStackInfo();
        outputRect = logConfig.isOutputRect();
    }
    /*
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

    public static void object(Object o){
        if(isDebug){
            AnnotationUtil annotationUtil=new AnnotationUtil();

            android.util.Log.d(TAG,annotationUtil.getA(o));
        }
    }

    /**
     * Building Message
     *
     * @param msg The message you would like logged.
     * @return Message String
     */
    private static String buildMessage(String msg) {
        StackTraceElement caller = new Throwable().fillInStackTrace().getStackTrace()[2];
        StringBuilder stackInfo = new StringBuilder().append(caller.getClassName()).append(".").append(caller.getMethodName()).append("(): ");

        OutPutMessage outPutMessage = outputRect ?
                new OutputRectStrategy(new LogMessage(stackInfo.toString(), msg)) :
                new NoRectStrategy(new LogMessage(stackInfo.toString(), msg));
        return outputStackInfo ?
                outPutMessage.stackInfo() + outPutMessage.outputMessage() :
                outPutMessage.outputMessage();
    }

}
