package com.dojo.number;

public class DoTheMagicVisitor implements MagicResultVisitor {
    private int result;
    private Logger logger;

    public DoTheMagicVisitor(Logger logger) {
        this.logger = logger;
        result = -1;
    }


    @Override
    public void visit(NegativeResult result) {
        logger.log("Just in case: " + result.getMessage());
    }

    @Override
    public void visit(BadLuckResult result) {

        logger.log("Bad luck message: " + result.getMessage());
    }

    @Override
    public void visit(DevilResult result) {
        logger.log("The devil's message: " + result.getMessage());

    }

    @Override
    public void visit(NumericResult result) {
        this.result = result.getResult();

    }

    @Override
    public void visit(OddResult result) {
        logger.log("Weird case: " + result.getMessage());
    }

    @Override
    public void visit(TooLowResult result) {
        logger.log("Too low: " + result.getMessage());

    }

    @Override
    public void visit(GiveMeFiveResult giveMeFiveResult) {
        logger.log("double dispatch pan pan");
    }

    public int getResult() {
        return result;
    }
}
