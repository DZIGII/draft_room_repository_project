package raf.draft.dsw.controller.messagegenerator;

public class LoggerFactory {

    public static Logger createLogger(String loggerType) {
        if("CONSOLE".equals(loggerType.toUpperCase())) {
            return new ConsoleLogger();
        }
        else if("FILE".equals(loggerType.toUpperCase())) {
            return new FileLogger();
        }
        return null;
    }


}
