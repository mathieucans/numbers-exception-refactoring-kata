package com.dojo.number;

public class NumberService {

    public void doTheMagic(int number, MagicCollaborator collaborator) {
        if (number == 666) {
            collaborator.devilResult("The devil exception");
        }else if (number == 5)
        {
            collaborator.giveMeFive();
        } else if (number == 13) {
            collaborator.badLuckResult("That's not my lucky number");
        } else if (number >= 10 && number <= 20) {
            collaborator.tooLowResult("You can do better");
        } else if (number >= 100 && number <= 200) {
            if (number % 2 == 0) {
                collaborator.numericResult(number * 3);
            } else {
                collaborator.oddResult("Hmm... no");
            }
        } else if (number < 0) {
            collaborator.negativeResult("Should not happen");
        }

        collaborator.numericResult(number * 2);
    }

    public void close() {
        // TODO: do stuff here
    }
}
