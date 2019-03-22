package com.dojo.number;

public class NumberService {

    public MagicResult doTheMagic(int number) {
        if (number == 666) {
            return new DevilResult("The devil exception");
        }else if (number == 5)
        {
            return new GiveMeFiveResult();
        } else if (number == 13) {
            return new BadLuckResult("That's not my lucky number");
        } else if (number >= 10 && number <= 20) {
            return new TooLowResult("You can do better");
        } else if (number >= 100 && number <= 200) {
            if (number % 2 == 0) {
                return new NumericResult(number * 3);
            } else {
                return new OddResult("Hmm... no");
            }
        } else if (number < 0) {
            return new NegativeResult("Should not happen");
        }

        return new NumericResult(number * 2);
    }

    public void close() {
        // TODO: do stuff here
    }
}
