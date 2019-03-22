package com.dojo.number;

public class NumberController {

    private Logger logger;
    private NumberService numberService;

    public NumberController(Logger logger, NumberService numberService) {
        this.logger = logger;
        this.numberService = numberService;
    }

    public int doTheMagic(int number) {
        MagicResult magicResult = numberService.doTheMagic(number);
        numberService.close();

        DoTheMagicVisitor visitor = new DoTheMagicVisitor(logger);
        magicResult.accept(visitor);

        return visitor.getResult();
    }
}
