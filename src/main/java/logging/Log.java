package logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;


public class Log {
    private static Logger logger = Log.getNamedLogger(Log.class.getSimpleName());

    /**
     * Log level:DEBUG
     * @param logger
     * @param level
     */
    public static void setLogLevel(Logger logger, String level){
        Level logLevel = Level.ERROR;
        switch (level.toUpperCase()){
            case "ERROR":
                  break;
            case "DEBUG":
                logLevel = Level.DEBUG;
                break;
            case "OFF":
                logLevel = Level.OFF;
                break;
            case "WARN":
                logLevel = Level.WARN;
                break;
            case "INFO":
                logLevel = Level.INFO;
                break;
            default:
                break;
        }
    }

    public static void setLevel(Logger logger, Level level){
        Configurator.setLevel(logger.getName(), level);
    }
    public static Logger getNamedLogger(String name) {
        return LogManager.getLogger(name);
    }
}
