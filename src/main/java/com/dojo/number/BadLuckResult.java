package com.dojo.number;

public class BadLuckResult extends MessageResult{

    public BadLuckResult(String message) {
        super(message);
    }

    @Override
    public void accept(MagicResultVisitor visitor) {
        visitor.visit(this);
    }
}
