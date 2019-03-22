package com.dojo.number;

public class TooLowResult extends MessageResult{
    public TooLowResult(String message) {
        super(message);
    }

    @Override
    public void accept(MagicResultVisitor visitor) {
        visitor.visit(this);
    }
}
