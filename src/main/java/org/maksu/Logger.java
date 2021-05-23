package org.maksu;

import org.apache.log4j.xml.DOMConfigurator;

public class Logger {

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);

    public Logger() {
        DOMConfigurator.configure("log4j.xml");
    }

    public void info(String str){
        logger.info(str);
    }

    public void warn(String str){
        logger.warn(str);
    }

    public void error(String str){
        logger.error(str);
    }

    public void durationInfo(String name, long duration) {
        String str =String.format("Method [%s] took %s ms.", name, duration);
        logger.info(str);
    }
}
