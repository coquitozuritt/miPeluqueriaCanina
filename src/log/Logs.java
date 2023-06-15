package log;

import java.util.logging.Logger;

public class Logs {
    public static final Logger LOGGER = Logger.getLogger(Logs.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Este es un mensaje de información");
        LOGGER.warning("Este es un mensaje de advertencia");
        LOGGER.severe("Este es un mensaje de error");
    }
}
