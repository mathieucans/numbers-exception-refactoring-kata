package com.dojo.number;

public class DoTheMagicCollaborator implements MagicCollaborator {
    private Logger logger;
    private int result = -1;

    public DoTheMagicCollaborator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void devilResult(String message) {
        logger.log("The devil's message: " + message);
    }

    @Override
    public void badLuckResult(String message) {
        logger.log("Bad luck message: " + message);
    }

    @Override
    public void giveMeFive() {
        logger.log("double dispatch pan pan");
    }

    @Override
    public void tooLowResult(String message) {
        logger.log("Too low: " + message);
    }

    @Override
    public void numericResult(int number) {
        this.result = number;
    }

    @Override
    public void oddResult(String message) {
        logger.log("Weird case: " + message);
    }

    @Override
    public void negativeResult(String message) {
        logger.log("Just in case: " + message);
    }

    public int getResult() {
        return result;
    }
}
