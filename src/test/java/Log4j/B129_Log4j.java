package Log4j;

import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class B129_Log4j {
    @Test
    public void log4j(){
        Logger logger = LogManager.getLogger("B129_Log4j.class");

        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARNING");
    }
}
