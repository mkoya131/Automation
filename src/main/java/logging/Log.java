package logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class Log {
    private static Logger logger = Logger.getLogger(Log.class.getSimpleName());
    /**
     * Log level:ERROR
     * @param tag
     * @param msg
     */
    public static void error(String tag, String msg){
        System.out.println("ERROR:" +tag + ": " + msg);
        logger.error("ERROR:" + ": " +msg);
    }

    /**
     * Log level:WARN
     * @param tag
     * @param msg
     */
    public static void warn(String tag, String msg){
        System.out.println("WARN:" +tag + ": " + msg);
        logger.warn("WARN:" + tag + ": " +msg);
    }
    /**
     * Log level:INFO
     * @param tag
     * @param msg
     */
    public static void info(String tag,String msg){
        System.out.println("INFO:" +tag +": " + msg);
        logger.info("INFO:" +tag + ": " +msg);
    }
    /**
     * Log level:DEBUG
     * @param tag
     * @param msg
     */
    public static void debug(String tag, String msg){
        System.out.println("DEBUG:" +tag + ": " + msg);
        logger.debug("DEBUG:" +tag + ": " +msg);

    }

    public static void testng(String msg){

    }
}
