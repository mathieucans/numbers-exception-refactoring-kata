package com.dojo.number;

public class NumberController {

    private Logger logger;
    private NumberService numberService;

    public NumberController(Logger logger, NumberService numberService) {
        this.logger = logger;
        this.numberService = numberService;
    }

    public int doTheMagic(int number) {
        DoTheMagicCollaborator collaborator = new DoTheMagicCollaborator(logger);
        numberService.doTheMagic(number, collaborator);
        numberService.close();

        return collaborator.getResult();
    }
}
