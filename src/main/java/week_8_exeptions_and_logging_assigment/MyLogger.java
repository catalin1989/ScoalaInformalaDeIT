package week_8_exeptions_and_logging_assigment;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

//I created my own logger which I want to use in all classes.
public class MyLogger {
    public static final Logger logger = Logger.getLogger(MyLogger.class.getName());
    private static String resourcesPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator;

    //  here I created a handler for the console and a handler for a log file
    static {
        try {
            FileHandler fileHandler = new FileHandler(resourcesPath + "myLogFile.log");
            ConsoleHandler consoleHandler = new ConsoleHandler();
            //I made a custom formatter
            Formatter formatter = new Formatter() {
                @Override
                public String format(LogRecord record) {
                    return String.format("%1$tY-%1$tm-%1$td %2$s: %3$s%n", record.getMillis(), record.getLevel(), record.getMessage());
                }
            };

            logger.setUseParentHandlers(false);//I disabled the root handler
            //added the handlers to the logger and set the lvl of information that should be logged to the specific destination
            consoleHandler.setFormatter(formatter);
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(formatter);
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(consoleHandler);
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);

        } catch (IOException e) {
            MyLogger.logger.severe(e.toString());
        }


    }

}
