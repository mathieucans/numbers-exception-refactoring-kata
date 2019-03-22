package com.dojo.number;

public class NegativeResult extends MessageResult {
    public NegativeResult(String message) {
        super(message);
    }

    @Override
    public void accept(MagicResultVisitor visitor) {
        visitor.visit(this);
    }
}
