package com.ustmportal.resources.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logss {
    // LOG CODE HERE?????
    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(Logss.class);
        logger.info("asdasf");
        logger.error("ERROR WHILE CONVERTING");
        logger.debug("asfsdofvsdogmsogsiogmsoggo");
    }
}
