//import java.io.*;
import java.io.IOException;
import java.io.File;
//import java.text.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//import java.util.*;
import java.util.Date;
//import java.util.logging.*;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TestClass {
    public static void main(String[] args) throws IOException {
        /* Ensure directory has been created */
        new File("logs").mkdir();
    
        /* Get  the date to be used in the filename */
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        Date now = new Date();
        String date = df.format(now);

        /* Set up the file name in the logs directory */
        String logFileName = "logs/testlog-" + date + ".txt";
        
        /* Set up Logger */
        FileHandler myFileHandler = new FileHandler(logFileName);
        myFileHandler.setFormatter(new SimpleFormatter());

        Logger myLogger = Logger.getLogger("My Logger");
        myLogger.setLevel(Level.ALL);
        myLogger.addHandler(myFileHandler);
        
        /* Log Message */
        myLogger.info("\nThis is a logged information message.");

        /* Close the file */
        myFileHandler.close();
    }
}
