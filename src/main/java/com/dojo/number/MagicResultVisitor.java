package com.dojo.number;

public interface MagicResultVisitor {
    void visit(NegativeResult negativeResult);

    void visit(BadLuckResult badLuckResult);

    void visit(DevilResult devilResult);

    void visit(NumericResult numericResult);

    void visit(OddResult oddResult);

    void visit(TooLowResult tooLowResult);

    void visit(GiveMeFiveResult giveMeFiveResult);
}
